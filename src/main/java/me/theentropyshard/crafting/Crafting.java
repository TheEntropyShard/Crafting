/*      A Java clone of Flash Player-Game Minecraft: Crafting made using JavaFX 8
 *      Copyright (C) 2022 TheEntropyShard
 *
 *      This program is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package me.theentropyshard.crafting;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The main Crafting class
 */
public class Crafting extends Application {
    public static final String TITLE = "Crafting";
    private static final int WIDTH = 480;
    private static final int HEIGHT = 332;
    private static final int START_BUTTON_X = 368;
    private static final int START_BUTTON_Y = 276;
    private static final int RESULT_SLOT_X = 248;
    private static final int RESULT_SLOT_Y = 70;
    private static final Item[] ITEMS = Arrays.stream(Item.ITEMS)
            .filter(item -> item.getId() != 0)
            .collect(Collectors.toList())
            .toArray(new Item[0]);
    private static final Item[] CRAFTABLE_ITEMS = Arrays.stream(Item.ITEMS)
            .filter(Item::isCraftable)
            .collect(Collectors.toList())
            .toArray(new Item[0]);

    private final AnchorPane root;
    private final Button startButton;
    private final Slot[] slots;
    private final Digit[] timerDigits;
    private final Digit[] scoreDigits;
    private final Random random;
    private final Slot cursor;
    private final AudioClip correctRecipe;
    private final AudioClip timerStarted;
    private final AudioClip timerRunning;
    private final Timeline timerTimeline;

    private int timer;
    private int score;
    private Item craftingItem;

    public Crafting() {
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
            //made for hiding a lot of exceptions in console
            //that appearing because of duplicate children added,
            //but if I do not do this, the cursor is not visible
        });

        this.root = new AnchorPane();
        this.startButton = new Button();
        this.slots = new Slot[46];
        this.timerDigits = new Digit[4];
        this.scoreDigits = new Digit[6];
        this.random = new Random();
        this.cursor = new Slot();
        this.correctRecipe = new AudioClip(Objects.requireNonNull(this.getClass().getResource("/sounds/correct_recipe.mp3")).toExternalForm());
        this.timerStarted = new AudioClip(Objects.requireNonNull(this.getClass().getResource("/sounds/start_timer.mp3")).toExternalForm());
        this.timerRunning = new AudioClip(Objects.requireNonNull(this.getClass().getResource("/sounds/timer_working.mp3")).toExternalForm());

        this.timerTimeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            this.timer--;
                            this.updateTimer();
                            if(this.timer == 0) {
                                this.stopTimer();
                            }
                        }));
        this.timerTimeline.setCycleCount(60);

        this.createGame();
        this.newGame();
    }

    public void start(Stage stage) {
        stage.getIcons().add(Utils.loadImage("/gui/icon.png"));
        stage.setTitle(Crafting.TITLE);
        stage.setResizable(false);
        stage.setScene(new Scene(this.root, Crafting.WIDTH, Crafting.HEIGHT));
        stage.sizeToScene();
        stage.show();
    }

    private void createGame() {
        this.root.setBackground(
                new Background(
                        new BackgroundImage(
                                Utils.loadImage("/gui/inventory.png"),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                )
        );
        this.root.setOnMousePressed(event -> {
            Node intersectedNode = event.getPickResult().getIntersectedNode();
            if(intersectedNode instanceof Slot) {
                if(Arrays.asList(this.slots).contains(intersectedNode)) {
                    return;
                }
            }
            this.destroyCursor();
        });
        this.root.setOnMouseMoved(event -> {
            this.cursor.setVisible(event.getX() < 352);
            this.cursor.setX(event.getX() - 16);
            this.cursor.setY(event.getY() - 16);
        });
        this.root.setOnMouseDragged(event -> {
            this.cursor.setVisible(event.getX() < 352);
            this.cursor.setX(event.getX() - 16);
            this.cursor.setY(event.getY() - 16);
            for(int i = 0; i < 9; i++) {
                Slot slot = this.slots[i];
                if(event.getPickResult().getIntersectedNode().equals(slot)) {
                    if(this.cursor.getImage() != null) {
                        slot.setImage(this.cursor.getImage());
                        slot.setSlotId(this.cursor.getSlotId());
                        this.checkRecipe();
                    }
                }
            }
        });

        ObservableList<Node> children = this.root.getChildren();

        this.startButton.setImage(Utils.loadImage("/gui/startButtonNotHovered.png"));
        this.startButton.setX(Crafting.START_BUTTON_X);
        this.startButton.setY(Crafting.START_BUTTON_Y);
        this.startButton.setOnMousePressed(event -> this.startGameByButton());
        this.startButton.setOnMouseEntered(event -> this.startButton.setImage(Utils.loadImage("/gui/startButtonHovered.png")));
        this.startButton.setOnMouseExited(event -> this.startButton.setImage(Utils.loadImage("/gui/startButtonNotHovered.png")));
        children.add(this.startButton);

        int veryUsefulVar = 0;

        while(veryUsefulVar < 45) {
            this.slots[veryUsefulVar] = new Slot();
            Slot slot = this.slots[veryUsefulVar];
            if(veryUsefulVar < 9) {
                slot.setX(veryUsefulVar % 3 * 36 + 60);
                slot.setY(Math.floor(veryUsefulVar / 3.0f) * 36 + 34);
                slot.setOnMousePressed(event -> {
                    if(this.cursor.getImage() != null) {
                        slot.setSlotId(this.cursor.getSlotId());
                        slot.setImage(this.cursor.getImage());
                        this.checkRecipe();
                    }
                });
            } else {
                slot.setX(veryUsefulVar % 9 * 36 + 16);
                slot.setY(Math.floor(veryUsefulVar / 9.0f) * 36 + 132);
                if(35 < veryUsefulVar) {
                    slot.setY(slot.getY() + 8);
                }
                slot.setOnMousePressed(event -> {
                    this.cursor.setImage(slot.getImage());
                    this.cursor.setX(event.getX() - 16);
                    this.cursor.setY(event.getY() - 16);
                    this.cursor.setSlotId(slot.getSlotId());
                    children.add(cursor);
                    children.add(cursor);
                });
            }
            veryUsefulVar++;
            children.add(slot);
        }
        veryUsefulVar = 0;

        this.slots[45] = new Slot();
        Slot resultSlot = this.slots[45];
        resultSlot.setSlotId(45);
        resultSlot.setX(Crafting.RESULT_SLOT_X);
        resultSlot.setY(Crafting.RESULT_SLOT_Y);
        children.add(resultSlot);

        while(veryUsefulVar < 6) {
            this.scoreDigits[veryUsefulVar] = new Digit();
            Digit digit = this.scoreDigits[veryUsefulVar];
            digit.setX(12 * veryUsefulVar + 381);
            digit.setY(28);
            veryUsefulVar++;
            children.add(digit);
        }
        veryUsefulVar = 0;

        while(veryUsefulVar < 4) {
            this.timerDigits[veryUsefulVar] = new Digit();
            Digit digit = this.timerDigits[veryUsefulVar];
            digit.setX(12 * veryUsefulVar + 391);
            if(veryUsefulVar > 1) {
                digit.setX(digit.getX() + 4);
            }
            digit.setY(76);
            veryUsefulVar++;
            children.add(digit);
        }

        this.cursor.setMouseTransparent(true);
        children.add(this.cursor);
    }

    private void startGameByButton() {
        this.newGame();
        this.startTimer();
    }

    private void startTimer() {
        this.timer = 60;
        this.updateTimer();

        this.timerStarted.stop();
        this.timerRunning.stop();

        this.timerStarted.play();
        this.timerRunning.setCycleCount(AudioClip.INDEFINITE);
        this.timerRunning.play();

        this.timerTimeline.stop();
        this.timerTimeline.play();
    }

    private void stopTimer() {
        this.timerTimeline.stop();
        this.timerRunning.stop();
    }

    private void destroyCursor() {
        this.root.getChildren().remove(this.cursor);
        this.cursor.setSlotId(0);
        this.cursor.setImage(null);
    }

    private void newGame() {
        this.destroyCursor();

        this.timer = 0;
        this.score = 0;

        this.updateTimer();
        this.updateScore();

        this.clearCraftingSlots();

        this.fillInventory();
        this.changeRecipe();
    }

    private void fillInventory() {
        for(int i = 9; i < this.slots.length - 1; i++) {
            Slot slot = this.slots[i];
            Item item = Crafting.ITEMS[random.nextInt(Crafting.ITEMS.length)];
            slot.setImage(item.getTexture());
            slot.setSlotId(item.getId());
        }
    }

    private void clearCraftingSlots() {
        for(int i = 0; i < 9; i++) {
            this.slots[i].setImage(null);
            this.slots[i].setSlotId(0);
        }
    }

    private void changeRecipe() {
        this.destroyCursor();

        this.clearCraftingSlots();
        this.fillInventory();

        this.craftingItem = Crafting.CRAFTABLE_ITEMS[random.nextInt(Crafting.CRAFTABLE_ITEMS.length)];
        this.slots[45].setSlotId(this.craftingItem.getId());
        this.slots[45].setImage(craftingItem.getTexture());
        Set<Integer> uniqueIds = new HashSet<>();
        for(int i : this.craftingItem.getRecipe()) {
            uniqueIds.add(i);
        }
        for(int i : uniqueIds) {
            int randomSlot = (int) (Math.random() * 36 + 9);
            for(Item item : Crafting.ITEMS) {
                if(item.getId() == i) {
                    this.slots[randomSlot].setImage(item.getTexture());
                    this.slots[randomSlot].setSlotId(item.getId());
                }
            }
        }
    }

    private void checkRecipe() {
        int[] recipe = this.craftingItem.getRecipe();
        if(
                this.slots[0].getSlotId() == recipe[0] &&
                this.slots[1].getSlotId() == recipe[1] &&
                this.slots[2].getSlotId() == recipe[2] &&
                this.slots[3].getSlotId() == recipe[3] &&
                this.slots[4].getSlotId() == recipe[4] &&
                this.slots[5].getSlotId() == recipe[5] &&
                this.slots[6].getSlotId() == recipe[6] &&
                this.slots[7].getSlotId() == recipe[7] &&
                this.slots[8].getSlotId() == recipe[8]
        ) {
            this.changeRecipe();
            if(this.timer != 0) {
                this.score += 23;
                this.updateScore();
            }
            this.root.getChildren().remove(this.cursor);
            this.correctRecipe.play();
        }
    }

    private void updateTimer() {
        this.timerDigits[0].setImage(Utils.parseDigit(Math.floorMod(this.timer, 3600) / 600));
        this.timerDigits[1].setImage(Utils.parseDigit(Math.floorMod(this.timer, 600) / 60));
        this.timerDigits[2].setImage(Utils.parseDigit(Math.floorMod(this.timer, 60) / 10));
        this.timerDigits[3].setImage(Utils.parseDigit(this.timer % 10));
    }

    private void updateScore() {
        this.scoreDigits[0].setImage(Utils.parseDigit(Math.floorMod(this.score, 1000000) / 100000));
        this.scoreDigits[1].setImage(Utils.parseDigit(Math.floorMod(this.score, 100000) / 10000));
        this.scoreDigits[2].setImage(Utils.parseDigit(Math.floorMod(this.score, 10000) / 1000));
        this.scoreDigits[3].setImage(Utils.parseDigit(Math.floorMod(this.score, 1000) / 100));
        this.scoreDigits[4].setImage(Utils.parseDigit(Math.floorMod(this.score, 100) / 10));
        this.scoreDigits[5].setImage(Utils.parseDigit(this.score % 10));
    }
}

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

import javafx.scene.image.Image;

public class Item {
    public static final Item[] ITEMS = new Item[] {
            new Item(
                    0,
                    "air",
                    new int[] {

                    }
            ),
            new Item(
                    1,
                    "activator_rail",
                    new int[] {
                            35, 55, 35,
                            35, 52, 35,
                            35, 55, 35
                    }
            ),
            new Item(
                    2,
                    "anvil",
                    new int[] {
                            33, 33, 33,
                            0,  35, 0,
                            35, 35, 35
                    }
            ),
            new Item(
                    3,
                    "beacon",
                    new int[] {
                            21, 21, 21,
                            21, 44, 21,
                            45, 45, 45
                    }
            ),
            new Item(
                    4,
                    "book",
                    new int[] {

                    }
            ),
            new Item(
                    5,
                    "bookshelf",
                    new int[] {
                            61, 61, 61,
                            4, 4, 4,
                            61, 61, 61
                    }
            ),
            new Item(
                    6,
                    "carrot",
                    new int[] {

                    }
            ),
            new Item(
                    7,
                    "chest",
                    new int[] {
                            61, 61, 61,
                            61,  0, 61,
                            61, 61, 61
                    }
            ),
            new Item(
                    8,
                    "cobblestone",
                    new int[] {

                    }
            ),
            new Item(
                    9,
                    "compass",
                    new int[] {
                            0, 35, 0,
                            35, 50, 35,
                            0, 35, 0
                    }
            ),
            new Item(
                    10,
                    "diamond",
                    new int[] {

                    }
            ),
            new Item(
                    11,
                    "diamond_block",
                    new int[] {
                            10, 10, 10,
                            10, 10, 10,
                            10, 10, 10
                    }
            ),
            new Item(
                    11,
                    "diamond_chestplate",
                    new int[] {
                            10, 0, 10,
                            10, 10, 10,
                            10, 10, 10
                    }
            ),
            new Item(
                    12,
                    "diamond_leggings",
                    new int[] {
                            10, 10, 10,
                            10, 0, 10,
                            10, 0, 10
                    }
            ),
            new Item(
                    13,
                    "diamond_pickaxe",
                    new int[] {
                            10, 10, 10,
                            0, 55, 0,
                            0, 55, 0
                    }
            ),
            new Item(
                    14,
                    "powered_rail",
                    new int[] {
                            27, 0, 27,
                            27, 55, 27,
                            27, 50, 27
                    }
            ),
            new Item(
                    15,
                    "emerald",
                    new int[] {

                    }
            ),
            new Item(
                    16,
                    "enchanting_table",
                    new int[] {
                            0, 4, 0,
                            10, 45, 10,
                            45, 45, 45
                    }
            ),
            new Item(
                    17,
                    "ender_chest",
                    new int[] {
                            45, 45, 45,
                            45, 18, 45,
                            45, 45, 45
                    }
            ),
            new Item(
                    18,
                    "ender_eye",
                    new int[] {

                    }
            ),
            new Item(
                    19,
                    "fishing_rod",
                    new int[] {
                            0, 0, 55,
                            0, 55, 58,
                            55, 0, 58
                    }
            ),
            new Item(
                    20,
                    "furnace",
                    new int[] {
                            8, 8, 8,
                            8, 0, 8,
                            8, 8, 8
                    }
            ),
            new Item(
                    21,
                    "glass",
                    new int[] {

                    }
            ),
            new Item(
                    22,
                    "glowing_melon",
                    new int[] {
                            28, 28, 28,
                            28, 43, 28,
                            28, 28, 28
                    }
            ),
            new Item(
                    23,
                    "glowstone",
                    new int[] {

                    }
            ),
            new Item(
                    24,
                    "gold_block",
                    new int[] {
                            27, 27, 27,
                            27, 27, 27,
                            27, 27, 27
                    }
            ),
            new Item(
                    25,
                    "gold_carrot",
                    new int[] {
                            28, 28, 28,
                            28,  6, 28,
                            28, 28, 28
                    }
            ),
            new Item(
                    26,
                    "gold_chestplate",
                    new int[] {
                            27, 0, 27,
                            27, 27, 27,
                            27, 27, 27
                    }
            ),
            new Item(
                    27,
                    "gold_ingot",
                    new int[] {
                            28, 28, 28,
                            28, 28, 28,
                            28, 28, 28
                    }
            ),
            new Item(
                    28,
                    "gold_nugget",
                    new int[] {

                    }
            ),
            new Item(
                    29,
                    "gold_pickaxe",
                    new int[] {
                            27, 27, 27,
                            0, 55, 0,
                            0, 55, 0
                    }
            ),
            new Item(
                    30,
                    "gunpowder",
                    new int[] {

                    }
            ),
            new Item(
                    31,
                    "haybale",
                    new int[] {
                            60, 60, 60,
                            60, 60, 60,
                            60, 60, 60
                    }
            ),
            new Item(
                    32,
                    "hopper",
                    new int[] {
                            35, 0, 35,
                            35, 7, 35,
                            0, 35, 0
                    }
            ),
            new Item(
                    33,
                    "iron_block",
                    new int[] {
                            35, 35, 35,
                            35, 35, 35,
                            35, 35, 35
                    }
            ),
            new Item(
                    34,
                    "iron_chestplate",
                    new int[] {
                            35, 0, 35,
                            35, 35, 35,
                            35, 35, 35
                    }
            ),
            new Item(
                    35,
                    "iron_ingot",
                    new int[] {

                    }
            ),
            new Item(
                    36,
                    "iron_leggings",
                    new int[] {
                            35, 35, 35,
                            35, 0, 35,
                            35, 0, 35
                    }
            ),
            new Item(
                    37,
                    "iron_pickaxe",
                    new int[] {
                            35, 35, 35,
                            0, 55, 0,
                            0, 55, 0
                    }
            ),
            new Item(
                    38,
                    "item_frame",
                    new int[] {
                            55, 55, 55,
                            55, 42, 55,
                            55, 55, 55
                    }
            ),
            new Item(
                    39,
                    "ladder",
                    new int[] {
                            55, 0, 55,
                            55, 55, 55,
                            55, 0, 55
                    }
            ),
            new Item(
                    40,
                    "lapis",
                    new int[] {

                    }
            ),
            new Item(
                    41,
                    "lapis_block",
                    new int[] {
                            40, 40, 40,
                            40, 40, 40,
                            40, 40, 40
                    }
            ),
            new Item(
                    42,
                    "leather",
                    new int[] {

                    }
            ),
            new Item(
                    43,
                    "melon",
                    new int[] {

                    }
            ),
            new Item(
                    44,
                    "nether_star",
                    new int[] {

                    }
            ),
            new Item(
                    45,
                    "obsidian",
                    new int[] {

                    }
            ),
            new Item(
                    46,
                    "piston",
                    new int[] {
                            61, 61, 61,
                            8, 35, 8,
                            8, 50, 8
                    }
            ),
            new Item(
                    47,
                    "detector_rail",
                    new int[] {

                    }
            ),
            new Item(
                    48,
                    "rail",
                    new int[] {
                            35, 0, 35,
                            35, 55, 35,
                            35, 0, 35
                    }
            ),
            new Item(
                    49,
                    "redstone_block",
                    new int[] {
                            50, 50, 50,
                            50, 50, 50,
                            50, 50, 50
                    }
            ),
            new Item(
                    50,
                    "redstone_dust",
                    new int[] {

                    }
            ),
            new Item(
                    51,
                    "redstone_lamp",
                    new int[] {
                            0, 50, 0,
                            50, 23, 50,
                            0, 50, 0
                    }
            ),
            new Item(
                    52,
                    "redstone_torch",
                    new int[] {

                    }
            ),
            new Item(
                    53,
                    "sand",
                    new int[] {

                    }
            ),
            new Item(
                    54,
                    "sign",
                    new int[] {
                            61, 61, 61,
                            61, 61, 61,
                            0, 55, 0
                    }
            ),
            new Item(
                    55,
                    "stick",
                    new int[] {

                    }
            ),
            new Item(
                    56,
                    "stone",
                    new int[] {

                    }
            ),
            new Item(
                    57,
                    "stonebrick",
                    new int[] {

                    }
            ),
            new Item(
                    58,
                    "string",
                    new int[] {

                    }
            ),
            new Item(
                    59,
                    "tnt",
                    new int[] {
                            30, 53, 30,
                            53, 30, 53,
                            30, 53, 30
                    }
            ),
            new Item(
                    60,
                    "wheat",
                    new int[] {

                    }
            ),
            new Item(
                    61,
                    "wood",
                    new int[] {

                    }
            )
    };

    private final int id;
    private final Image texture;
    private final int[] recipe;

    public Item(int id, String texturePath, int[] recipe) {
        this.id = id;
        this.texture = texturePath.equals("air") ? null : Utils.loadImage("/textures/" + texturePath + ".png");
        this.recipe = recipe;
    }

    public int getId() {
        return this.id;
    }

    public Image getTexture() {
        return this.texture;
    }

    public int[] getRecipe() {
        return this.recipe;
    }

    public boolean isCraftable() {
        return this.recipe.length != 0;
    }
}

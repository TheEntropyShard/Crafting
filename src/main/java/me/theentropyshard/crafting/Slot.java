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

import javafx.scene.image.ImageView;

public class Slot extends ImageView {
    private int id;

    public Slot() {
        this.setPickOnBounds(true);
        this.setFitWidth(32);
        this.setFitHeight(32);
    }

    public int getSlotId() {
        return id;
    }

    public void setSlotId(int id) {
        this.id = id;
    }
}

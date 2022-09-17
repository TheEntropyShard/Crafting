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

import java.util.HashMap;
import java.util.Map;

public final class Utils {
    public static final Image[] digits = new Image[10];
    public static final Map<String, Image> cachedImages = new HashMap<>();

    static {
        for(int i = 0; i < digits.length; i++) {
            digits[i] = Utils.loadImage(String.format("/gui/digits/%d.png", i));
        }
    }

    public static Image loadImage(String path) {
        if(Utils.cachedImages.containsKey(path)) {
            return Utils.cachedImages.get(path);
        }
        Image image = new Image(path);
        cachedImages.put(path, image);
        return image;
    }

    public static Image parseDigit(int i) {
        if(i < 0 || i > 9) return Utils.digits[0];
        return Utils.digits[i];
    }
}

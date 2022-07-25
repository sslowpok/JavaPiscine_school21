package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Logic {

    public static int[][] readBmpImage(String filePath, char whiteChar, char blackChar) {

        try {

            BufferedImage image = ImageIO.read(new FileInputStream(filePath));

            int[][] array2d = new int[image.getHeight()][image.getWidth()];

            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {

                    int color = image.getRGB(i, j);
                    if (color == Color.BLACK.getRGB()) {
                        array2d[i][j] = blackChar;
                    } else if (color == Color.WHITE.getRGB()) {
                        array2d[i][j] = whiteChar;
                    }

                }
            }


            return array2d;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

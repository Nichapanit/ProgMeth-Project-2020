package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class InfoLabel extends Label {
	public static final String FONT_PATH = "res/kenvector_future.ttf";
	public static final String BACKGROUND_PATH = ClassLoader.getSystemResource("yellow_small_panel.png").toString();

	public InfoLabel(String text) {
		this.setPrefHeight(49);
		this.setPrefWidth(350);
		this.setText(text);
		this.setWrapText(true);
		this.setLabelFont();
		this.setAlignment(Pos.CENTER);

		BackgroundImage background = new BackgroundImage(new Image(BACKGROUND_PATH,350,49, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
	}

	private void setLabelFont() {
		try {
			this.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 16));
		} catch (FileNotFoundException e) {
			this.setFont(Font.font("Verdana", 23));
			System.out.println("Font is not connected");

		}
	}

}

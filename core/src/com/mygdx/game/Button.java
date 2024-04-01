package com.mygdx.game;

import static com.mygdx.game.MyHorrorGame.*;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

public class Button {
    BitmapFont font;
    String text;
    float x, y;
    float width, height;

    public Button(String text, float x, float y, BitmapFont font) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
        height = layout.height;
    }

    public Button(String text, float y, BitmapFont font, int align) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
        height = layout.height;
        if(align == Align.center){
            x = SCR_WIDTH/2 - width/2;
        }
        if(align == Align.left){
            x = 0;
        }
        if(align == Align.right){
            x = SCR_WIDTH - width;
        }
    }

    boolean hitButton(float tx, float ty) {
        return x < tx & tx < x+width & y-height < ty & ty < y;
    }

    void setText(String text) {
        this.text = text;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
    }
}

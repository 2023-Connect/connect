import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Config {
    // String
    private String title = "Connect";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // font
    private Font fontBlack = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Black.ttf"));
    private Font fontBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Bold.ttf"));
    private Font fontExtraBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-ExtraBold.ttf"));
    private Font fontExtraLight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-ExtraLight.ttf"));
    private Font fontLight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Light.ttf"));
    private Font fontMedium = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Medium.ttf"));
    private Font fontRegular = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Regular.ttf"));
    private Font fontSemiBold = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-SemiBold.ttf"));
    private Font fontThin = Font.createFont(Font.TRUETYPE_FONT, new File("Font/NotoSansKR-Thin.ttf"));

    // Font getter & setter

    public Font getFontBlack() {
        return fontBlack;
    }

    public void setFontBlack(Font fontBlack) {
        this.fontBlack = fontBlack;
    }

    public Font getFontBold() {
        return fontBold;
    }

    public void setFontBold(Font fontBold) {
        this.fontBold = fontBold;
    }

    public Font getFontExtraBold() {
        return fontExtraBold;
    }

    public void setFontExtraBold(Font fontExtraBold) {
        this.fontExtraBold = fontExtraBold;
    }

    public Font getFontExtraLight() {
        return fontExtraLight;
    }

    public void setFontExtraLight(Font fontExtraLight) {
        this.fontExtraLight = fontExtraLight;
    }

    public Font getFontLight() {
        return fontLight;
    }

    public void setFontLight(Font fontLight) {
        this.fontLight = fontLight;
    }

    public Font getFontMedium() {
        return fontMedium;
    }

    public void setFontMedium(Font fontMedium) {
        this.fontMedium = fontMedium;
    }

    public Font getFontRegular() {
        return fontRegular;
    }

    public void setFontRegular(Font fontRegular) {
        this.fontRegular = fontRegular;
    }

    public Font getFontSemiBold() {
        return fontSemiBold;
    }

    public void setFontSemiBold(Font fontSemiBold) {
        this.fontSemiBold = fontSemiBold;
    }

    public Font getFontThin() {
        return fontThin;
    }

    public void setFontThin(Font fontThin) {
        this.fontThin = fontThin;
    }


    // color
    private Color mainColor = Color.decode("#FFF17E");
    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Config() throws IOException, FontFormatException {
    }
}

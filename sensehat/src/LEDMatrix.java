/**
 * Created by jcincera on 20/06/2017.
 */
class LEDMatrix extends APIBase {

    LEDMatrix() {
    }

    /**
     * Switch rotation/orientation of display
     *
     * @param rotation rotation angle
     */
    //todo probably doesn't work properly in Python core
    void setRotation(Rotation rotation) {
        execute(Command.SET_ROTATION, rotation.getRotation()).checkEmpty();
    }

    /**
     * Set all pixels on display
     *
     * @param pixels array of 64 pixels which represents display 8x8 points
     */
    void setPixels(Color[] pixels) {
        if (pixels == null || pixels.length != 64) {
            throw new IllegalArgumentException("Array must have 64 items -> 8x8 points!");
        }

        StringBuilder matrix = new StringBuilder();

        for (Color pixel : pixels) {
            matrix.append("[");
            matrix.append(pixel.r());
            matrix.append(", ");
            matrix.append(pixel.g());
            matrix.append(", ");
            matrix.append(pixel.b());
            matrix.append("],");
        }

        matrix.deleteCharAt(matrix.length() - 1); // remove last ","
        execute(Command.SET_PIXELS, matrix.toString()).checkEmpty();
    }

    /**
     * Set specific pixel
     *
     * @param x     index 0-7
     * @param y     index 0-7
     * @param color color
     */
    void setPixel(Integer x, Integer y, Color color) {
        execute(Command.SET_PIXEL,
                String.valueOf(x), String.valueOf(y),
                color.r(), color.g(), color.b()).checkEmpty();
    }

    /**
     * Clear display (blank/off)
     */
    void clear() {
        execute(Command.CLEAR).checkEmpty();
    }

    /**
     * Clear display - set all pixels to specific color
     *
     * @param color color
     */
    void clear(Color color) {
        execute(Command.CLEAR_WITH_COLOR, color.r(), color.g(), color.b()).checkEmpty();
    }

    /**
     * Show message
     *
     * @param message message
     */
    void showMessage(String message) {
        if (message.contains("'")) {
            throw new IllegalArgumentException("Character: > ' < is not supported in message!");
        }

        execute(Command.SHOW_MESSAGE, message).checkEmpty();
    }

    /**
     * Show message with specific parameters
     *
     * @param message     message
     * @param scrollSpeed speed
     * @param textColor   text color
     * @param backColor   background color
     */
    void showMessage(String message, Float scrollSpeed, Color textColor, Color backColor) {
        if (message.contains("'")) {
            throw new IllegalArgumentException("Character: > ' < is not supported in message!");
        }

        execute(Command.SHOW_MESSAGE_PARAMETRIZED,
                message,
                String.format("%.2f", scrollSpeed),
                textColor.r(), textColor.g(), textColor.b(),
                backColor.r(), backColor.g(), backColor.b()).checkEmpty();
    }

    /**
     * Wait for some message or event
     *
     * @param seconds seconds
     */
    void waitFor(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show letter
     *
     * @param letter letter
     */
    void showLetter(String letter) {
        if (letter.contains("'")) {
            throw new IllegalArgumentException("Letter: > ' < is not supported!");
        }
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Only one letter is supported!");
        }

        execute(Command.SHOW_LETTER, letter).checkEmpty();
    }

    /**
     * Show letter with specific parameters
     *
     * @param letter      letter
     * @param letterColor letter color
     * @param backColor   background color
     */
    void showLetter(String letter, Color letterColor, Color backColor) {
        execute(Command.SHOW_LETTER_PARAMETRIZED,
                letter,
                letterColor.r(), letterColor.g(), letterColor.b(),
                backColor.r(), backColor.g(), backColor.b()).checkEmpty();
    }

    /**
     * Set low light of matrix
     *
     * @param lowLight true/false
     */
    void lowLight(boolean lowLight) {
        execute(Command.LOW_LIGHT, PythonUtils.toBoolean(lowLight)).checkEmpty();
    }

    void gamma() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    void gammaReset() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    void loadImage() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    void flipHorizontally() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    void flipVertically() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    void getPixels() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    void getPixel() {
        throw new UnsupportedOperationException("Not supported yet");
    }
}

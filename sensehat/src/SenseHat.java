/**
 * Created by jcincera on 04/07/2017.
 */
public class SenseHat {
    public final EnvironmentalSensor environmentalSensor;
    public final IMU IMU;
    public final LEDMatrix ledMatrix;
    public final Joystick joystick;

    public SenseHat() {
        this.environmentalSensor = new EnvironmentalSensor();
        this.IMU = new IMU();
        this.ledMatrix = new LEDMatrix();
        this.joystick = new Joystick();
    }

    /**
     * Set all pixels on display
     *
     * @param pixels array of 64 pixels which represents display 8x8 points
     */
    public void setPixels(Color[] pixels) {
        this.ledMatrix.setPixels(pixels);
    }

    /**
     * Set specific pixel
     *
     * @param x     index 0-7
     * @param y     index 0-7
     * @param color color
     */
    public void setPixel(int x, int y, Color color) {
        this.ledMatrix.setPixel(x, y, color);
    }

    /**
     * Clear display (blank/off)
     */
    public void clearPixels() {
        this.ledMatrix.clear();
    }

    /**
     * Clear display - set all pixels to specific color
     *
     * @param color color
     */
    public void clearPixels(Color color) {
        this.ledMatrix.clear(color);
    }

    /**
     * Show message
     *
     * @param message message
     */
    public void showMessage(String message) {
        this.ledMatrix.showMessage(message);
    }

    /**
     * Show message with specific parameters
     *
     * @param message     message
     * @param scrollSpeed speed
     * @param textColor   text color
     * @param backColor   background color
     */
    public void showMessage(String message, double scrollSpeed, Color textColor, Color backColor) {
        this.ledMatrix.showMessage(message, (float) scrollSpeed, textColor, backColor);
    }

    /**
     * Wait for some message or event
     *
     * @param seconds seconds
     */
    public void waitFor(int seconds) {
        this.ledMatrix.waitFor(seconds);
    }

    /**
     * Show letter
     *
     * @param letter letter
     */
    public void showLetter(String letter) {
        this.ledMatrix.showLetter(letter);
    }

    /**
     * Show letter with specific parameters
     *
     * @param letter      letter
     * @param letterColor letter color
     * @param backColor   background color
     */
    public void showLetter(String letter, Color letterColor, Color backColor) {
        this.ledMatrix.showLetter(letter, letterColor, backColor);
    }

    /**
     * Set low light of matrix
     *
     * @param lowLight true/false
     */
    public void lowLight(boolean lowLight) {
        this.ledMatrix.lowLight(lowLight);
    }

    /**
     * Gets the percentage of relative humidity from the humidity sensor
     *
     * @return the percentage of relative humidity
     */
    public double getHumidity() {
        return this.environmentalSensor.getHumidity();
    }

    /**
     * Calls get_temperature_from_humidity internally in Python core
     *
     * @return the current temperature in degrees Celsius
     */
    public double getTemperature() {
        return this.environmentalSensor.getTemperature();
    }

    /**
     * Gets the current temperature in degrees Celsius from the humidity sensor
     *
     * @return the current temperature in degrees Celsius
     */
    public double getTemperatureFromHumidity() {
        return this.environmentalSensor.getTemperatureFromHumidity();
    }

    /**
     * Gets the current temperature in degrees Celsius from the pressure sensor
     *
     * @return the current temperature in degrees Celsius
     */
    public double getTemperatureFromPressure() {
        return this.environmentalSensor.getTemperatureFromPressure();
    }

    /**
     * Gets the current pressure in Millibars from the pressure sensor
     *
     * @return the current pressure in Millibars
     */
    public double getPressure() {
        return this.environmentalSensor.getPressure();
    }

    /**
     * Enables and disables the gyroscope, accelerometer and/or magnetometer contribution to the get orientation functions
     *
     * @param compassEnabled       enable compass
     * @param gyroscopeEnabled     enable gyroscope
     * @param accelerometerEnabled enable accelerometer
     */
    public void setIMUConfig(boolean compassEnabled, boolean gyroscopeEnabled, boolean accelerometerEnabled) {
        this.IMU.setIMUConfig(compassEnabled, gyroscopeEnabled, accelerometerEnabled);
    }

    /**
     * Gets the current orientation in radians using the aircraft principal axes of pitch, roll and yaw
     *
     * @return Object with pitch, roll and yaw values. Values are Floats representing the angle of the axis in radians
     */
    public IMUData getOrientationRadians() {
        return this.IMU.getOrientationRadians();
    }

    /**
     * Gets the current orientation in degrees using the aircraft principal axes of pitch, roll and yaw
     *
     * @return Object with pitch, roll and yaw values. Values are Floats representing the angle of the axis in degrees
     */
    public IMUData getOrientationDegrees() {
        return this.IMU.getOrientationDegrees();
    }

    /**
     * Calls get_orientation_degrees internally in Python core
     *
     * @return Object with pitch, roll and yaw representing the angle of the axis in degrees
     */
    public IMUData getOrientation() {
        return this.IMU.getOrientation();
    }

    /**
     * Calls set_imu_config internally in Python core to disable the gyroscope and accelerometer
     * then gets the direction of North from the magnetometer in degrees
     *
     * @return The direction of North
     */
    public double getCompass() {
        return this.IMU.getCompass();
    }

    /**
     * Gets the raw x, y and z axis magnetometer data
     *
     * @return Object representing the magnetic intensity of the axis in microteslas (uT)
     */
    public IMUDataRaw getCompassRaw() {
        return this.IMU.getCompassRaw();
    }

    /**
     * Calls set_imu_config internally in Python core to disable the magnetometer and accelerometer
     * then gets the current orientation from the gyroscope only
     *
     * @return Object with pitch, roll and yaw representing the angle of the axis in degrees
     */
    public IMUData getGyroscope() {
        return this.IMU.getGyroscope();
    }

    /**
     * Gets the raw x, y and z axis gyroscope data
     *
     * @return Object representing the rotational intensity of the axis in radians per second
     */
    public IMUDataRaw getGyroscopeRaw() {
        return this.IMU.getGyroscopeRaw();
    }

    /**
     * Calls set_imu_config in Python core to disable the magnetometer and gyroscope
     * then gets the current orientation from the accelerometer only
     *
     * @return Object representing the angle of the axis in degrees
     */
    public IMUData getAccelerometer() {
        return this.IMU.getAccelerometer();
    }

    /**
     * Gets the raw x, y and z axis accelerometer data
     *
     * @return Object representing the acceleration intensity of the axis in Gs
     */
    public IMUDataRaw getAccelerometerRaw() {
        return this.IMU.getAccelerometerRaw();
    }

    /**
     * Blocks execution until a joystick event occurs
     *
     * @return event type which occured
     */
    public JoystickEvent waitForJSEvent() {
        return this.joystick.waitForEvent();
    }

    /**
     * Blocks execution until a joystick event occurs
     *
     * @param emptyBuffer can be used to flush any pending events before waiting for new events
     * @return event type which occured
     */
    public JoystickEvent waitForJSEvent(boolean emptyBuffer) {
        return this.joystick.waitForEvent(emptyBuffer);
    }
}

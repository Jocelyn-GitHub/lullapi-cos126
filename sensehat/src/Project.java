/**
 * Created by jcincera on 03/07/2017.
 */
public class Project {

    private static Color[] pixels = new Color[64];

    public static void main(String[] args) {
        System.out.println(">>> Create project here <<<");

        SenseHat senseHat = new SenseHat();

        for (int i = 0; i < 64; ++i) {
            pixels[i] = Color.of(i * 4, 0, 0);
        }

        // environmental
        double humidity = senseHat.getHumidity();
        System.out.println("Current humidity: " + humidity);
        double temperature = senseHat.getTemperature();
        System.out.println("Current temperature: " + temperature);
        double pressure = senseHat.getPressure();
        System.out.println("Current pressure: " + pressure);
        double tempFromHum = senseHat.getTemperatureFromHumidity();
        System.out.println("Current temperature from humidity sensor: " + tempFromHum);
        double tempFromPre = senseHat.getTemperatureFromPressure();
        System.out.println("Current pressure from pressure sensor: " + tempFromPre);

        // imu
        double compass = senseHat.getCompass();
        System.out.println("Current compass: " + compass);
        IMUDataRaw compassRaw = senseHat.getCompassRaw();
        double compassX = compassRaw.getX();
        System.out.println("Current compass x: " + compassX);
        double compassY = compassRaw.getY();
        System.out.println("Current compass y: " + compassY);
        double compassZ = compassRaw.getZ();
        System.out.println("Current compass z: " + compassZ);

        IMUData accelerometer = senseHat.getAccelerometer();
        double accP = accelerometer.getPitch();
        double accR = accelerometer.getRoll();
        double accY = accelerometer.getYaw();
        System.out.println("Current Accelerometer: Roll " + accR + ", Pitch " + accP + ", Yaw " + accY);

        IMUDataRaw accelerometerRaw = senseHat.getAccelerometerRaw();
        double accRX = accelerometerRaw.getX();
        double accRY = accelerometerRaw.getY();
        double accRZ = accelerometerRaw.getZ();
        System.out.println("Current Accelerometer Raw: x " + accRX + ", y " + accRY + ", z " + accRZ);

        IMUData gyro = senseHat.getGyroscope();
        double GyroX = gyro.getPitch();
        double GyroY = gyro.getRoll();
        double GyroZ = gyro.getYaw();
        System.out.println("Current Gyro: x " + GyroX + ", y " + GyroY + ", z " + GyroZ);

        IMUDataRaw gyroRaw = senseHat.getGyroscopeRaw();
        double gyroRawX = gyroRaw.getX();
        double gyroRawY = gyroRaw.getY();
        double gyroRawZ = gyroRaw.getZ();
        System.out.println("Current Gyro Raw: x " + gyroRawX + ", y " + gyroRawY + ", z " + gyroRawZ);

        IMUData orientation = senseHat.getOrientation();
        double orientationP = orientation.getPitch();
        double orientationR = orientation.getRoll();
        double orientationY = orientation.getYaw();
        System.out.println("Current Orientation: Roll " + orientationR + ", Pitch " + orientationP + ", Yaw " + orientationY);

        IMUData orientationDeg = senseHat.getOrientationDegrees();
        double orientationDegP = orientationDeg.getPitch();
        double orientationDegR = orientationDeg.getRoll();
        double orientationDegY = orientationDeg.getYaw();
        System.out.println("Current Orientation Degrees: Roll " + orientationDegR + ", Pitch " + orientationDegP + ", Yaw " + orientationDegY);

        IMUData orientationRad = senseHat.getOrientationDegrees();
        double orientationRadP = orientationRad.getPitch();
        double orientationRadR = orientationRad.getRoll();
        double orientationRadY = orientationRad.getYaw();
        System.out.println("Current Orientation Radians: Roll " + orientationRadP + ", Pitch " + orientationRadR + ", Yaw " + orientationRadY);

        // LEDMatrix
        senseHat.waitFor(3);

        senseHat.setPixels(pixels);
        senseHat.setPixel(0, 0, Color.of(0, 0, 255));

        senseHat.showLetter("A");
        senseHat.showLetter("b", Color.of(0, 0, 255), Color.of(0, 127, 0));

        senseHat.showMessage("Hello, World!");
        senseHat.showMessage("A", 0.20f, Color.of(0, 0, 0), Color.of(127, 127, 127));

        senseHat.lowLight(true);
        senseHat.clearPixels(Color.BLUE);

        // joystick
        senseHat.waitForJSEvent();
        senseHat.clearPixels();
    }
}

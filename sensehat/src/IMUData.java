/**
 * Created by jcincera on 28/06/2017.
 */
public class IMUData {

    private float pitch;
    private float roll;
    private float yaw;

    public IMUData(float pitch, float roll, float yaw) {
        this.pitch = pitch;
        this.roll = roll;
        this.yaw = yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public double getRoll() {
        return roll;
    }

    public double getYaw() {
        return yaw;
    }
}

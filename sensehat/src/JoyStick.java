import java.util.List;

/**
 * Created by jcincera on 20/06/2017.
 */
class Joystick extends APIBase {

    Joystick() {
    }

    /**
     * Blocks execution until a joystick event occurs
     *
     * @return event type which occured
     */
    JoystickEvent waitForEvent() {
        return waitForEvent(false);
    }

    /**
     * Blocks execution until a joystick event occurs
     *
     * @param emptyBuffer can be used to flush any pending events before waiting for new events
     * @return event type which occured
     */
    JoystickEvent waitForEvent(boolean emptyBuffer) {
        return execute(Command.WAIT_FOR_EVENT_EMPTY_BUFFER, PythonUtils.toBoolean(emptyBuffer)).getJoystickEvent();
    }

    /**
     * Returns a list of events representing all events that have occurred since the last call to getEvents or waitForEvent
     *
     * @return list of events
     */
    List<JoystickEvent> getEvents() {
        throw new UnsupportedOperationException("Not supported yet!");
    }
}

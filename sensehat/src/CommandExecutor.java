/**
 * Created by jcincera on 21/06/2017.
 */
public interface CommandExecutor {

    String lineSeparator = System.getProperty("line.separator");

    CommandResult execute(Command command, String... args);
}

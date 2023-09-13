/**
 * Created by jcincera on 27/06/2017.
 */
public class MultipleCommandExecutor implements CommandExecutor {

    MultipleCommandExecutor() {
        String osArch = System.getProperty("os.arch").toLowerCase();
        if (!(osArch.contains("arm") || osArch.contains("aarch64"))) {
            throw new InvalidSystemArchitectureException("System architecture is not supported for this command executor");
        }
    }

    @Override
    public CommandResult execute(Command command, String... args) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}

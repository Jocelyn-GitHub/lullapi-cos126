import org.jfugue.player.Player;

/*
LullaPi client class
 */
public class LullaPi {

    public static void main(String[] args) {


        // initialize player object
        Player player = new Player();

        // start up song
        player.play("F C G");
        double[] samples1 = StdAudio.read("lullapi.wav");
        StdAudio.play(samples1);

        // take in command line for which mode user wants
        String mode = args[0];

        /*
        PiPlay plays a notes based on the pitch and roll orientation of the
        Raspberry Pi and displays the notes being played on the LEDdisplay board
         */

        if (mode.equals("PiPlay")) {
            // number of notes they want between 0 and 7
            int a = Integer.parseInt(args[1]);
            // checks to make sure the user specified a valid number of notes
            if (a > 7) {
                throw new IllegalArgumentException("Number of notes specified is greater that 7");
            }

            // jfugue player class can play C D E F G A B
            String avaliableNotes = "CDEFGAB";
            String[] lullapiNotes = new String[a]; // string array of notes on pi
            for (int i = 0; i < a; i++) {
                // initializes the notes into the lullapi notes string array
                lullapiNotes[i] = avaliableNotes.substring(i, i + 1);
            }

            // initialize SenseHat object
            SenseHat senseHat = new SenseHat();

            // number of notes on each orientation
            int p = (int) (a / 2.0 + 0.5); // number of notes on pitch
            int r = a / 2; // number of notes on roll

            double pitch;
            double roll;

            for (; ; ) {
                // get orientation
                IMUData orientation = senseHat.getOrientation();
                pitch = orientation.getPitch();
                roll = orientation.getRoll();

                // initialize the indices of the notes to be played
                int index;
                int jindex;

                // half of the notes will be based on pitch, other half based on roll
                // index of note to be played based on pitch
                index = (int) (pitch * (p / 360.0));
                // index of note to be played based on roll
                jindex = (int) (roll * (r / 360.0) + p);

                // show message first so it scrolls while note is played
                // displays which notes are being played
                // first is pitch not, second is roll note
                senseHat.showMessage(lullapiNotes[index] + lullapiNotes[jindex]);

                // plays pitch note first
                player.play(lullapiNotes[index]);
                // plays roll note
                player.play(lullapiNotes[jindex]);

            }
        }

        /*
        AutoPlay plays a random song from the soundtrack with lights
        corresponding to the notes played at that moment
         */
        else if (mode.equals("AutoPlay")) {

            AutoPlay soundtrack = new AutoPlay();
            SenseHat secondSenseHat = new SenseHat();

            for (; ; ) {
                // joystick stick code adapted from precept assignment p07-sensehat
                // process Joystick input
                JoystickEvent e = secondSenseHat.waitForJSEvent();
                Action action = e.getAction();
                if (action == Action.PRESSED || action == Action.HELD) {
                    // index of the track played from soundtrack selected at
                    // random when the joystick is pressed
                    int index = StdRandom.uniformInt(soundtrack.getLength());
                    // gets the string of the song chosen at random
                    String song = soundtrack.getSong(index);
                    // plays the song with colors
                    soundtrack.play(song);
                }
            }
        }


        /* Autoplay plays a random song when the joystick is pressed or held */
        else if (mode.equals("NightPlay")) { // night mode
            AutoPlay soundtrackNight = new AutoPlay();
            SenseHat night = new SenseHat();
            night.showMessage("* Have a blessed night sleep :) *");
            for (; ; ) {
                // index of the track played from soundtrack selected at
                // random when the joystick is pressed
                int index = StdRandom.uniformInt(soundtrackNight.getLength());
                // plays the song at that index in the soundtrack
                soundtrackNight.nightPlay(index);
            }
        }
    }
}

package group3.modelFolder.compendium;

import java.util.HashMap;
import java.util.Map;

public class Compendium implements CompendiumModelInterface {
    private Map<String, Boolean> smurfs;

    public Compendium() {
        smurfs = new HashMap<>();
        // Add all smurfs to the compendium as undiscovered
        smurfs.put("Smurf1", false);
        smurfs.put("Smurf2", false);
        // Add more smurfs as needed...
    }

    // Call this method when a smurf is discovered
    public void discoverSmurf(String smurfName) {
        if (smurfs.containsKey(smurfName)) {
            smurfs.put(smurfName, true);
        }
    }

    // Call this method to check if a smurf has been discovered
    public boolean isSmurfDiscovered(String smurfName) {
        return smurfs.getOrDefault(smurfName, false);
    }

    // Call this method to get the discovery status of all smurfs
    public Map<String, Boolean> getAllSmurfs() {
        return new HashMap<>(smurfs);
    }
}
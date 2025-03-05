package engine.fixed;

public class EnergyBar {
    private int energy;
    private final int maxEnergy;

    public EnergyBar(int maxEnergy) {
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy;
    }

    public void modifyEnergy(int amount) {
        this.energy += amount;
        if (this.energy > maxEnergy) {
            this.energy = maxEnergy;
        } else if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }
}

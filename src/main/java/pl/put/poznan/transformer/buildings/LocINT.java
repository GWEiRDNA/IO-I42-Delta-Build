package pl.put.poznan.transformer.buildings;

/**
 *  Interface for Composite design pattern
 */
public interface LocINT {
    /**
     * Returns area of the location in square meters
     * @return  <code>double</code>
     */
    double     getArea();

    /**
     * Returns cubature of the location in cubic meters
     * @return  <code>double</code>
     */
    double     getCapacity();

    /**
     * Returns power of light of the location
     * @return  <code>double</code>
     */
    double     getLight();

    /**
     * Returns the level of energy usage required for heating of the location.
     * @return  <code>double</code>
     */
    double     getHeating();
}
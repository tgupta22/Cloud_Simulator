package hw_441;


/**
 * This class helps in calculating the cost and time.
 */
class Cost {

    double time_zone = 10.0;         // time zone this resource located
    double cost = 3.0;              // the cost of using processing in this resource
    double costPerMem = 0.05;		// the cost of using memory in this resource
    double costPerStorage = 0.1;	// the cost of using storage in this resource
    double costPerBw = 0.1;

    Cost characteristics = new Cost(time_zone, cost, costPerMem, costPerStorage, costPerBw);

    public Cost(double time_zone, double cost, double costPerMem, double costPerStorage, double costPerBw) {
        this.time_zone = time_zone;
        this.cost = cost;
        this.costPerMem = costPerMem;
        this.costPerStorage = costPerStorage;
    }
}

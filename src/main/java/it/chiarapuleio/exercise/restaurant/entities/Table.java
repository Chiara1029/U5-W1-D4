package it.chiarapuleio.exercise.restaurant.entities;

import it.chiarapuleio.exercise.restaurant.enums.TableStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {
    private int tableNumber;
    private int tableSeatsMax;
    private TableStatus tableStatus;

    public Table(int tableNumber, int tableChargeMax, TableStatus tableStatus) {
        this.tableNumber = tableNumber;
        this.tableSeatsMax = tableChargeMax;
        this.tableStatus = tableStatus;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", tableSeatsMax=" + tableSeatsMax +
                ", tableStatus=" + tableStatus +
                '}';
    }
}

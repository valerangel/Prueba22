package Map;

import Pjs.*;

public class Cell {
    private TypeOfCell typeOfCell;
    private Unit unit;

    public Cell (Unit unit){
        if(unit == null){
            this.typeOfCell = TypeOfCell.EMPTYCELL;
            return;
        }

        this.unit = unit;
        this.typeOfCell = TypeOfCell.WITH_UNIT;
    }

    public TypeOfCell getTypeOfCell(){
        return this.typeOfCell;
    }

    public Unit getUnit(){
        return this.unit;
    }

}

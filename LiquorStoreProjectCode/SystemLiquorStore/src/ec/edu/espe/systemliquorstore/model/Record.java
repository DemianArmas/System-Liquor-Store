package ec.edu.espe.systemliquorstore.model;

/**
 *
 * @author Demian Armas, Logical Lords, @ESPE
 */
public class Record {

    private int recordId;
    private String printedText;

    public Record(int recordId, String printedText) {
        this.recordId = recordId;
        this.printedText = printedText;
    }

    public void printReceipt() {
        System.out.println("======== RECIBO " + recordId + " ========");
        System.out.println(printedText);
        System.out.println("============================");
    }

    @Override
    public String toString() {
        return "Record{recordId=" + recordId + ", printedText=" + printedText + '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getPrintedText() {
        return printedText;
    }

    public void setPrintedText(String printedText) {
        this.printedText = printedText;
    }

}

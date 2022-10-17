package Products;


import Enums.ScannerForm;

public class Scanner extends Typewriter{
    int pagesPerToner;
    ScannerForm form;
    
    public Scanner(String name, String storeZone, String state, double price, int pagesPerMinute, int pagesPerToner, String form) {
        super(name, storeZone, state, price, pagesPerMinute);
        this.pagesPerToner = pagesPerToner;
        this.form = ScannerForm.valueOf(form);
    }

    @Override
    public void setMode(String newMode) {
        form = ScannerForm.valueOf(newMode);
    }
    @Override
    public String toString() {
        return String.format("%s \nPages/Toner: %s \nForm: %s", super.toString(), pagesPerToner, form.toString());
    }
}

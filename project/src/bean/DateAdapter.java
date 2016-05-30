package bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;
// Used to format dates when marshaling(saving to xml) so that they are in a neat format
public class DateAdapter extends XmlAdapter<String, Calendar> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");

    @Override
    public String marshal(Calendar v) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(v.getTime());
        }
    }

    @Override
    public Calendar unmarshal(String v) throws Exception {
        synchronized (dateFormat) {
        	Calendar calendar = Calendar.getInstance();
        	calendar.setTime(dateFormat.parse(v));
            return calendar;
        }
    }

}

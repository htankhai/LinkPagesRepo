
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class Main {

  @WebMethod
  public String getTime() {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    return (sdf.format(calendar.getTime()));

  }

}
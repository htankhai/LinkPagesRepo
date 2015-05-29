package soapRequest;
import javax.xml.soap.*;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.net.URL;
public class Request {
	public static void main(String[] args)    {
        try {
            SOAPConnectionFactory soapConnectionFactory =
                SOAPConnectionFactory.newInstance();
            SOAPConnection connection =
                soapConnectionFactory.createConnection();

            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();

            SOAPHeader header = message.getSOAPHeader();
            SOAPBody body = message.getSOAPBody();
            header.detachNode();

            QName bodyName = new QName("http://wombat.ztrade.com",
                "GetLastTradePrice", "m");
            SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

            QName name = new QName("symbol");
            SOAPElement symbol = bodyElement.addChildElement(name);
            symbol.addTextNode("SUNW");

            URL endpoint = new URL("http://wombat.ztrade.com/quotes");
            SOAPMessage response = connection.call(message, endpoint);

            connection.close();

            SOAPBody soapBody = response.getSOAPBody();

            Iterator iterator = soapBody.getChildElements(bodyName);
            bodyElement = (SOAPBodyElement)iterator.next();
            String lastPrice = bodyElement.getValue();

            System.out.print("The last price for SUNW is ");
            System.out.println(lastPrice);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/**SOAP messaging occurs when a SOAP message, produced by a message factory , is sent to
  an endpoint by way of a connection .


If you are working without a provider, you must do the following:

Create a SOAPConnectionFactory object.

Create a SOAPConnection object.

Create an Endpoint object that represents the message�s destination.

Create a MessageFactory object and use it to create a message.

Populate the message.

Send the message.*/
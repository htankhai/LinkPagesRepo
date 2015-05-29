package com.example.helloandroid.test;
//Test program using Android Test framework
import com.example.helloandroid.HelloAndroid;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class HelloAndroidTest extends ActivityInstrumentationTestCase2 <HelloAndroid> {
    
	private HelloAndroid mActivity;
	private TextView mView;
	private String resourceString;
	private Solo solo;
	
	public HelloAndroidTest () {
		// TODO Auto-generated constructor stub
		super("com.example.helloandroid",HelloAndroid.class);	
	}
	
	 @Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
	//	super.setUp();
		 
	 	mActivity = this.getActivity();
		solo = new Solo(getInstrumentation(),getActivity());
		mView = (TextView) mActivity.findViewById(com.example.helloandroid.R.id.textview2);
		resourceString = mActivity.getString(com.example.helloandroid.R.string.hello_world);
		
	}
	 
	 @Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		//super.tearDown();
		solo.finishOpenedActivities();
	}
	
	public void testPrecondition() {
		assertNotNull(mView);
	}
	
	/* test Target application contains a text display "Hello World!"*/
	public void testSearchText() {
		assertEquals(resourceString,(String) mView.getText());
	}
	
	/* test HelloAndroid Activity on target application is exist*/
	public void testCurrentActivity() throws Exception  {
    	solo.assertCurrentActivity("wrong activity", HelloAndroid.class);
    }
    
	/* test Application UI contains "Start" button */
	/* send event click button to target application */
    public void testSearchButton() throws Exception {
    	boolean found = solo.searchButton("Start");
    	solo.clickOnButton("Start");
    	assertTrue(found);
    }

	

}

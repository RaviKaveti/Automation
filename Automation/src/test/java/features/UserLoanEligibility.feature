Feature: Test the Loan calculator functionality


Scenario Outline: Verifying the Customer loan eligibility details

Given User lands on the ANZ Loan Calculator page <Applurl>
When User clicks on <Applicationtype> selects <NumberofDependents> and clicks on <Propertyyouwouldliketobuy> under Your details section
And Also enters <Yourincome> per year and <Yourotherincome> per year under Your earnings section
And Lastly enters <Livingexpenses> per month <Currenthomeloanrepayments> per month <Otherloanrepayments> per month <Othercommitments> per month and <Totalcreditcardlimits> under Your expenses
And User clicks on Work out how much I could borrow
Then User would be shown the estimated amount 
And User close the browser

Examples:-

|Applicationtype | NumberofDependants|Propertyyouwouldliketobuy|Yourincome|Yourotherincome|Livingexpenses|Currenthomeloanrepayments|Otherloanrepayments|Othercommitments|Totalcreditcardlimits|Applurl|

|Single					 |0	             		 |Home to Live in		       |80000     |10000          |500            |0			        				 |100		     				 |0 	         		|10000		       			|https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/|


Scenario Outline: Verifying the existing information in Loan Calculater page gets refreshed

Given User lands on the ANZ Loan Calculator page <Applurl>
When User clicks on <Applicationtype> selects <NumberofDependents> and clicks on <Propertyyouwouldliketobuy> under Your details section
And Also enters <Yourincome> per year and <Yourotherincome> per year under Your earnings section
And Lastly enters <Livingexpenses> per month <Currenthomeloanrepayments> per month <Otherloanrepayments> per month <Othercommitments> per month and <Totalcreditcardlimits> under Your expenses
And User clicks on Work out how much I could borrow
Then User would be shown the estimated amount 
And User clicks on Start Over button
And User close the browser

Examples:-

|Applicationtype | NumberofDependants|Propertyyouwouldliketobuy|Yourincome|Yourotherincome|Livingexpenses|Currenthomeloanrepayments|Otherloanrepayments|Othercommitments|Totalcreditcardlimits|Applurl|

|Single					 |0	             		 |Home to Live in		       |80000     |10000          |500            |0			        				 |100		     				 |0 	         		|10000		       			|https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/|


Scenario Outline: Verifying the Customer loan eligibility details when the Living expenses is $1

Given User lands on the ANZ Loan Calculator page <Applurl>
When User clicks on <Applicationtype> selects <NumberofDependents> and clicks on <Propertyyouwouldliketobuy> under Your details section
And Also enters <Yourincome> per year and <Yourotherincome> per year under Your earnings section
And Lastly enters <Livingexpenses> per month <Currenthomeloanrepayments> per month <Otherloanrepayments> per month <Othercommitments> per month and <Totalcreditcardlimits> under Your expenses
And User clicks on Work out how much I could borrow
Then User would be shown the message 
And User close the browser


Examples:-

|Applicationtype | NumberofDependants|Propertyyouwouldliketobuy|Yourincome|Yourotherincome|Livingexpenses|Currenthomeloanrepayments|Otherloanrepayments|Othercommitments|Totalcreditcardlimits|Applurl|

|Single					 |0	             		 |Home to Live in		       |0   	 	  |0		          |1	           |0			        				 |0				     				 |0 	         		|0			       			  |https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/|		



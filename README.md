
                          Sears.com Results Text Scraper

  What is it?
  -----------

  Sears.com Results Text Scraper is a text scraper to query total number of results
  and query details of result objects.

  Approach
  ------------------

  The following is the approach of project:
  1. get input from command line interface
  2. trim input and check whether the input is valid and display responding notification
  3. call responding method of query controller
  4. in order to get complete query URL, query controller calls URL controller
  5. query controller takes advantage of jsoup to get dom document from Sears.com
  6. then query controller parse the dom docuemnt for required information and store them in model part
  7. query controller sends required information back to view
  8. view part shows the results.

  Structure of project
  ------------

  The project basically consists of 5 parts:
  1. model part for storage of dom document and information of product
  2. view part for input from user and display output in the screen
  3. controller part for interaction between model and view part and scrape information from Sears.com
     and there are three controllers in this part. 
     3.1 QueryController   : major functions are to retrieve dom document from website, 
                             count total number of results, and query all results details
     3.2 TextTrimController: major functions are to trim the keyword, page number and check 
                             whether page number is numeric
     3.3 UrlController     : major function is to construct the query URL from input
  4. test part for java unit test of major functions in controllers
  5. exception part for java exception handling. The exceptions include EmptyInputException, InvalidNumberOfInputException, and NonNumericPageNumber.

  FAQ
  -------------
  1. If the current price of product is empty to unavailable, the program would only display "not available" instead the out-of-time price  

  Referenced Library
  -------------

  1. jsoup-1.7.3.jar
  2. junit-4.12-beta-2.jar

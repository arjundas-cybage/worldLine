

const fs = require('fs');
const message = " Sunday's fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000) .";
var fromDate  = 1901;
var toDate    = 2001;
fs.writeFile("../Output.txt", firstSundays(fromDate, toDate), function (err) {
  if (err) {
    return console.log(err);
  }
  console.log("The file was saved!");
});

function firstSundays(fromDate,toDate ) {
  //Declaration of week in an array 
  var daysOfWeek = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
  var countOfSundays = 0;
    //iterating over the years
  for (; fromDate < toDate; fromDate++) {
  //iterating over the months
    for (let month = 1; month < 13; month++) {
      let specificDate = new Date(fromDate, month, 1);
      //finding sundays
      let day = daysOfWeek[specificDate.getDay()];
      if (day == 'Sun') {
        console.log(specificDate.toString() + '..');
        countOfSundays++;
      }
    }
  }
  return countOfSundays + message ;
}





CREATE DATABASE IF NOT EXISTS support;

USE support;

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS custprod;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS nextproblemid;
DROP TABLE IF EXISTS problems;
DROP TABLE IF EXISTS problog;
DROP TABLE IF EXISTS products;

CREATE TABLE customers (
  customerID char(8) default NULL,
  name char(40) default NULL,
  phone char(16) default NULL
);

INSERT INTO customers VALUES ('ADDIFK01','Frank Addinsell','(718) 555-3911');
INSERT INTO customers VALUES ('ALBIBB01','Bob Albinoni','(213) 555-7566');
INSERT INTO customers VALUES ('ALBRDE01','Dave Albrechtsberger','(508) 555-1216');
INSERT INTO customers VALUES ('ALKAJM01','Jim Alkan','(832) 555-5617');
INSERT INTO customers VALUES ('ARENDE01','Dave Arensky','(604) 555-5461');
INSERT INTO customers VALUES ('AUBEJL01','Jill Auber','(832) 555-8480');
INSERT INTO customers VALUES ('BAZZJL01','Jill Bazzini','(213) 555-7252');
INSERT INTO customers VALUES ('BELLJR01','Jennifer Bellini','(215) 555-4485');
INSERT INTO customers VALUES ('BENDJN01','John Benda','(313) 555-0963');
INSERT INTO customers VALUES ('BOCHRD01','Richard Bochsa','(203) 555-0440');
INSERT INTO customers VALUES ('BOYCDA01','Donna Boyce','(215) 555-3444');
INSERT INTO customers VALUES ('CHERFK01','Frank Cherubini','(718) 555-2303');
INSERT INTO customers VALUES ('CHOPED01','Ed Chopin','(516) 555-4544');
INSERT INTO customers VALUES ('CRAMHH01','Hugh Cramer','(203) 555-8205');
INSERT INTO customers VALUES ('CROFJL01','Jill Croft','(213) 555-8917');
INSERT INTO customers VALUES ('ERKEMY01','Molly Erkel','(604) 555-9825');
INSERT INTO customers VALUES ('FIELKE01','Kate Field','(718) 555-9283');
INSERT INTO customers VALUES ('FROBJN01','John Froberger','(212) 555-0743');
INSERT INTO customers VALUES ('GADEDE01','Dave Gade','(914) 555-1135');
INSERT INTO customers VALUES ('GODAAA01','Amanda Godard','(914) 555-4063');
INSERT INTO customers VALUES ('GRIEFK01','Frank Grieg','(832) 555-9236');
INSERT INTO customers VALUES ('HOLSJL01','Jill Holst','(516) 555-2656');
INSERT INTO customers VALUES ('LITOKE01','Kate Litolff','(215) 555-8297');
INSERT INTO customers VALUES ('LOCARD01','Richard Locatelli','(832) 555-9968');
INSERT INTO customers VALUES ('MERCDE01','Dave Mercadante','(314) 555-5242');
INSERT INTO customers VALUES ('MEYERD01','Richard Meyerbeer','(213) 555-3854');
INSERT INTO customers VALUES ('MILLJN01','John Milloecker','(415) 555-9714');
INSERT INTO customers VALUES ('MOLIER01','Eleanor Molique','(314) 555-6432');
INSERT INTO customers VALUES ('PAGAER01','Eleanor Paganini','(314) 555-4173');
INSERT INTO customers VALUES ('PERGJN01','John Pergolesi','(919) 555-5871');
INSERT INTO customers VALUES ('PUCCLN01','Lillian Puccini','(516) 555-6366');
INSERT INTO customers VALUES ('PURCFK01','Frank Purcell','(516) 555-7542');
INSERT INTO customers VALUES ('RHEIJM01','Jim Rheinberger','(212) 555-6343');
INSERT INTO customers VALUES ('SATIJR01','Jennifer Satie','(919) 555-8285');
INSERT INTO customers VALUES ('SCARHH01','Hugh Scarlatti','(508) 555-8820');
INSERT INTO customers VALUES ('SCHUBB01','Bob Schumann','(832) 555-5021');
INSERT INTO customers VALUES ('STRAJN01','John Strauss','(202) 555-0734');
INSERT INTO customers VALUES ('SULLJN01','John Sullivan','(206) 555-3674');
INSERT INTO customers VALUES ('TARTAA01','Amanda Tartini','(212) 555-4697');
INSERT INTO customers VALUES ('TELEHH01','Hugh Telemann','(718) 555-2808');
INSERT INTO customers VALUES ('TOREFK01','Frank Torelli','(832) 555-2751');
INSERT INTO customers VALUES ('VERDJN01','John Verdi','(914) 555-4544');
INSERT INTO customers VALUES ('VITADA01','Donna Vitali','(313) 555-2885');
INSERT INTO customers VALUES ('VIVALN01','Lillian Vivaldi','(832) 555-9693');
INSERT INTO customers VALUES ('WAGNER01','Eleanor Wagner','(213) 555-4183');
INSERT INTO customers VALUES ('WEBEJN01','John Webern','(832) 555-0664');
INSERT INTO customers VALUES ('WESLJE01','Jane Wesley','(215) 555-6669');

CREATE TABLE custprod (
  customerID char(8) default NULL,
  productID char(6) default NULL,
  datePurchased date default NULL
);

INSERT INTO custprod VALUES ('ADDIFK01','023500','2002-02-04');
INSERT INTO custprod VALUES ('ADDIFK01','023570','2003-10-03');
INSERT INTO custprod VALUES ('ALBIBB01','023550','2001-11-25');
INSERT INTO custprod VALUES ('ALBRDE01','023530','2003-06-28');
INSERT INTO custprod VALUES ('ALBRDE01','023590','2001-03-21');
INSERT INTO custprod VALUES ('ALKAJM01','023500','2001-11-22');
INSERT INTO custprod VALUES ('ARENDE01','023570','2002-11-04');
INSERT INTO custprod VALUES ('AUBEJL01','023540','2001-11-07');
INSERT INTO custprod VALUES ('BAZZJL01','023530','2002-01-14');
INSERT INTO custprod VALUES ('BAZZJL01','023500','2001-10-18');
INSERT INTO custprod VALUES ('BAZZJL01','023510','2003-03-27');
INSERT INTO custprod VALUES ('BELLJR01','023500','2002-12-17');
INSERT INTO custprod VALUES ('BELLJR01','023530','2003-11-06');
INSERT INTO custprod VALUES ('BELLJR01','023540','2001-05-04');
INSERT INTO custprod VALUES ('BENDJN01','023510','2002-10-05');
INSERT INTO custprod VALUES ('BOCHRD01','023500','2002-09-01');
INSERT INTO custprod VALUES ('BOCHRD01','023510','2002-06-04');
INSERT INTO custprod VALUES ('BOCHRD01','023590','2003-04-11');
INSERT INTO custprod VALUES ('BOYCDA01','023580','2003-09-14');
INSERT INTO custprod VALUES ('CHERFK01','023500','2001-07-11');
INSERT INTO custprod VALUES ('CHOPED01','023530','2002-10-21');
INSERT INTO custprod VALUES ('CHOPED01','023500','2002-06-02');
INSERT INTO custprod VALUES ('CHOPED01','023510','2001-10-12');
INSERT INTO custprod VALUES ('CRAMHH01','023600','2002-01-17');
INSERT INTO custprod VALUES ('CROFJL01','023500','2003-06-07');
INSERT INTO custprod VALUES ('ERKEMY01','023550','2001-06-25');
INSERT INTO custprod VALUES ('ERKEMY01','023500','2001-12-27');
INSERT INTO custprod VALUES ('FIELKE01','023550','2003-04-17');
INSERT INTO custprod VALUES ('FROBJN01','023570','2003-12-15');
INSERT INTO custprod VALUES ('FROBJN01','023500','2002-04-06');
INSERT INTO custprod VALUES ('FROBJN01','023530','2001-05-14');
INSERT INTO custprod VALUES ('GADEDE01','023570','2002-08-15');
INSERT INTO custprod VALUES ('GADEDE01','023600','2002-12-09');
INSERT INTO custprod VALUES ('GADEDE01','023500','2002-11-15');
INSERT INTO custprod VALUES ('GRIEFK01','023510','2003-10-20');
INSERT INTO custprod VALUES ('HOLSJL01','023510','2002-07-23');
INSERT INTO custprod VALUES ('LOCARD01','023500','2003-05-15');
INSERT INTO custprod VALUES ('LOCARD01','023510','2002-05-09');
INSERT INTO custprod VALUES ('LOCARD01','023540','2001-02-22');
INSERT INTO custprod VALUES ('MERCDE01','023550','2001-10-02');
INSERT INTO custprod VALUES ('MILLJN01','023500','2001-11-02');
INSERT INTO custprod VALUES ('MILLJN01','023550','2003-08-20');
INSERT INTO custprod VALUES ('PAGAER01','023500','2003-10-22');
INSERT INTO custprod VALUES ('PAGAER01','023540','2002-02-19');
INSERT INTO custprod VALUES ('PERGJN01','023520','2001-02-02');
INSERT INTO custprod VALUES ('PUCCLN01','023510','2003-07-19');
INSERT INTO custprod VALUES ('PUCCLN01','023500','2003-03-20');
INSERT INTO custprod VALUES ('PURCFK01','023530','2001-08-19');
INSERT INTO custprod VALUES ('PURCFK01','023570','2002-03-10');
INSERT INTO custprod VALUES ('PURCFK01','023510','2002-08-04');
INSERT INTO custprod VALUES ('RHEIJM01','023530','2002-06-12');
INSERT INTO custprod VALUES ('SATIJR01','023550','2002-06-17');
INSERT INTO custprod VALUES ('SATIJR01','023590','2003-02-12');
INSERT INTO custprod VALUES ('SCARHH01','023520','2002-06-07');
INSERT INTO custprod VALUES ('SCHUBB01','023500','2003-10-15');
INSERT INTO custprod VALUES ('SCHUBB01','023560','2003-04-21');
INSERT INTO custprod VALUES ('STRAJN01','023500','2001-11-16');
INSERT INTO custprod VALUES ('SULLJN01','023530','2002-12-04');
INSERT INTO custprod VALUES ('SULLJN01','023570','2001-03-21');
INSERT INTO custprod VALUES ('TARTAA01','023510','2002-04-22');
INSERT INTO custprod VALUES ('TARTAA01','023570','2003-08-10');
INSERT INTO custprod VALUES ('TELEHH01','023570','2001-05-07');
INSERT INTO custprod VALUES ('TELEHH01','023600','2003-12-06');
INSERT INTO custprod VALUES ('TOREFK01','023530','2003-08-02');
INSERT INTO custprod VALUES ('VERDJN01','023500','2001-06-28');
INSERT INTO custprod VALUES ('VERDJN01','023510','2001-07-20');
INSERT INTO custprod VALUES ('VERDJN01','023540','2001-09-24');
INSERT INTO custprod VALUES ('VIVALN01','023540','2001-08-04');
INSERT INTO custprod VALUES ('VIVALN01','023510','2002-05-13');
INSERT INTO custprod VALUES ('WAGNER01','023540','2002-02-13');
INSERT INTO custprod VALUES ('WAGNER01','023570','2002-08-09');
INSERT INTO custprod VALUES ('WAGNER01','023500','2001-08-20');
INSERT INTO custprod VALUES ('WESLJE01','023520','2003-03-05');
INSERT INTO custprod VALUES ('WESLJE01','023570','2002-05-14');
INSERT INTO custprod VALUES ('WESLJE01','023500','2001-03-24');

CREATE TABLE departments (
  departmentID char(2) default NULL,
  name char(32) default NULL
);

INSERT INTO departments VALUES ('CC','Call Center');
INSERT INTO departments VALUES ('EX','Executive');
INSERT INTO departments VALUES ('FI','Finance');
INSERT INTO departments VALUES ('HR','Human Resources');
INSERT INTO departments VALUES ('IT','Information Technology');
INSERT INTO departments VALUES ('MK','Marketing');
INSERT INTO departments VALUES ('PC','Purchasing');
INSERT INTO departments VALUES ('PD','Product Development');
INSERT INTO departments VALUES ('PS','Product Support');
INSERT INTO departments VALUES ('QA','Quality Assurance');
INSERT INTO departments VALUES ('SP','Shipping');

CREATE TABLE employees (
  employeeID char(4) default NULL,
  name char(20) default NULL,
  dateHired date default NULL,
  isManager tinyint(1) default NULL,
  departmentID char(2) default NULL,
  title char(50) default NULL,
  email char(32) default NULL,
  phone char(4) default NULL
);


INSERT INTO employees VALUES ('0010','Samuel Hassinger','1977-06-14',0,'PS','Technical Support Analyst III','shassinger@lyricnote.com','5120');
INSERT INTO employees VALUES ('0020','Dorothy Wendecker','1977-07-19',0,'HR','Compensation Manager','dwendecker@lyricnote.com','5161');
INSERT INTO employees VALUES ('0030','Mathias Strayer','1978-02-08',1,'SP','Shipping Manager','mstrayer@lyricnote.com','5130');
INSERT INTO employees VALUES ('0040','Fred Albright','1978-04-04',0,'PS','Technical Support Analyst II','falbright@lyricnote.com','5112');
INSERT INTO employees VALUES ('0050','Catherine Brenner','1978-08-16',1,'EX','President and CEO','cbrenner@lyricnote.com','5104');
INSERT INTO employees VALUES ('0060','Eve Miller','1978-08-26',0,'CC','Product Support Representative','emiller@lyricnote.com','5134');
INSERT INTO employees VALUES ('0070','Susanna Gaster','1978-09-05',0,'QA','Tester','sgaster@lyricnote.com','5162');
INSERT INTO employees VALUES ('0080','Anna Martin','1978-10-03',0,'PS','Technical Support Analyst III','amartin@lyricnote.com','5123');
INSERT INTO employees VALUES ('0090','Michael Metz','1979-07-25',0,'QA','Tester','mmetz@lyricnote.com','5106');
INSERT INTO employees VALUES ('0100','Andrew Roush','1980-03-16',0,'IT','Systems Analyst','aroush@lyricnote.com','5114');
INSERT INTO employees VALUES ('0110','Maria Thomas','1981-07-07',0,'CC','Product Support Representative','mthomas@lyricnote.com','5116');
INSERT INTO employees VALUES ('0120','John Augustine','1981-10-16',0,'MK','Marketing Representative','jaugustine@lyricnote.com','5127');
INSERT INTO employees VALUES ('0130','Catherine Schech','1982-06-18',1,'IT','Director of Information Technology','cschech@lyricnote.com','5110');
INSERT INTO employees VALUES ('0140','John Schech','1982-06-18',0,'PD','Principal Software Developer','jschech@lyricnote.com','5128');
INSERT INTO employees VALUES ('0150','Eva Schech','1982-06-24',0,'EX','Administrative Assistant','eschech@lyricnote.com','5122');
INSERT INTO employees VALUES ('0160','John Bickel','1982-08-18',0,'EX','Senior VP and COO','jbickel@lyricnote.com','5159');
INSERT INTO employees VALUES ('0170','Simon Bickel','1982-08-18',1,'PD','Director of Product Development','sbickel@lyricnote.com','5139');
INSERT INTO employees VALUES ('0180','Thomas Bickel','1982-08-18',0,'MK','Marketing Representative','tbickel@lyricnote.com','5111');
INSERT INTO employees VALUES ('0190','Jacob Rau','1983-11-10',0,'PD','Senior Software Developer','jrau@lyricnote.com','5102');
INSERT INTO employees VALUES ('0200','Joshua Reynolds','1984-06-21',0,'CC','Product Support Representative','jreynolds@lyricnote.com','5186');
INSERT INTO employees VALUES ('0210','Alice Gabriel','1984-07-21',0,'QA','Tester','agabriel@lyricnote.com','5119');
INSERT INTO employees VALUES ('0220','Mary Wright','1986-12-09',0,'IT','Senior Programmer','mwright@lyricnote.com','5107');
INSERT INTO employees VALUES ('0230','Susan Killian','1989-10-23',0,'EX','Administrative Assistant','skillian@lyricnote.com','5132');
INSERT INTO employees VALUES ('0240','Violet Barber','1990-03-23',0,'PD','Software Developer','vbarber@lyricnote.com','5156');
INSERT INTO employees VALUES ('0250','James Wellington','1990-08-30',0,'PS','Technical Support Analyst II','jwellington@lyricnote.com','5168');
INSERT INTO employees VALUES ('0260','Adam Smith','1991-12-06',0,'SP','Shipping Clerk','asmith@lyricnote.com','5144');
INSERT INTO employees VALUES ('0270','Magdalene Renner','1992-01-03',1,'PC','Purchasing Manager','mrenner@lyricnote.com','5109');
INSERT INTO employees VALUES ('0280','Anna Maria Clemens','1992-03-05',0,'PD','Senior Software Developer','amclemens@lyricnote.com','5113');
INSERT INTO employees VALUES ('0290','David Ulam','1992-03-28',0,'FI','Comptroller','dulam@lyricnote.com','5146');
INSERT INTO employees VALUES ('0300','George Stephenson','1992-08-05',0,'PS','Technical Support Analyst II','gstephenson@lyricnote.com','5166');
INSERT INTO employees VALUES ('0310','Margaret Miller','1993-08-17',0,'PD','Software Developer','mmiller@lyricnote.com','5179');
INSERT INTO employees VALUES ('0320','Douglas Benton','1993-09-03',0,'FI','Payroll Administrator','dbenton@lyricnote.com','5101');
INSERT INTO employees VALUES ('0330','John Glass','1993-10-15',0,'PC','Purchasing Specialist','jglass@lyricnote.com','5115');
INSERT INTO employees VALUES ('0340','Elizabeth Hendricks','1994-02-11',0,'PD','Software Developer','ehendricks@lyricnote.com','5121');
INSERT INTO employees VALUES ('0350','Gray Raphael','1994-03-22',0,'IT','Web Developer','graphael@lyricnote.com','5138');
INSERT INTO employees VALUES ('0360','Hung Kuo-fan','1994-05-18',0,'PS','Technical Support Analyst II','hkuofan@lyricnote.com','5125');
INSERT INTO employees VALUES ('0370','Nicholas Thiers','1994-09-13',0,'PD','Software Developer','nthiers@lyricnote.com','5105');
INSERT INTO employees VALUES ('0380','Conrad Stock','1994-09-22',1,'MK','VP and Director of Marketing','cstock@lyricnote.com','5167');
INSERT INTO employees VALUES ('0390','George Conrad','1994-11-01',0,'QA','Quality Control Analyst','gconrad@lyricnote.com','5136');
INSERT INTO employees VALUES ('0400','Susan Bastian','1995-03-21',0,'QA','Quality Control Analyst','sbastian@lyricnote.com','5108');
INSERT INTO employees VALUES ('0410','Elizabeth Faust','1995-10-05',0,'IT','Web Developer','efaust@lyricnote.com','5129');
INSERT INTO employees VALUES ('0420','Rita Fall','1995-10-09',0,'HR','Benefits Administrator','rfall@lyricnote.com','5133');
INSERT INTO employees VALUES ('0430','Theresa McDonald','1995-11-29',1,'FI','Executive VP and CFO','tmcdonald@lyricnote.com','5153');
INSERT INTO employees VALUES ('0440','Louis Krouse','1997-01-24',0,'FI','Accountant','lkrouse@lyricnote.com','5137');
INSERT INTO employees VALUES ('0450','George Bauer','1997-04-12',0,'FI','Auditor','gbauer@lyricnote.com','5124');
INSERT INTO employees VALUES ('0460','Gina Cardenas','1998-09-04',0,'IT','Programmer','gcardenas@lyricnote.com','5147');
INSERT INTO employees VALUES ('0470','Anna Maria Pontius','2000-06-12',0,'IT','Programmer','ampontius@lyricnote.com','5173');
INSERT INTO employees VALUES ('0480','Stuart Michael','2000-12-20',1,'PS','Manager of Product Support','smichael@lyricnote.com','5103');
INSERT INTO employees VALUES ('0490','Henry Meyer','2001-03-06',0,'CC','Product Support Representative','hmeyer@lyricnote.com','5141');
INSERT INTO employees VALUES ('0500','Juan Pablo Garcia','2002-02-05',1,'HR','Director of Human Resources','jpgarcia@lyricnote.com','5154');

CREATE TABLE events (
  eventID char(3) default NULL,
  description char(32) default NULL,
  isClosingEvent tinyint(1) default NULL
);

INSERT INTO events VALUES ('COM','Comments', 0);
INSERT INTO events VALUES ('CSI','Customer interviewed', 0);
INSERT INTO events VALUES ('RPS','Routed to product support', 0);
INSERT INTO events VALUES ('RPD','Routed to development', 0);
INSERT INTO events VALUES ('RQA','Routed to test', 0);
INSERT INTO events VALUES ('DEF','Deferred', 0);
INSERT INTO events VALUES ('CNB','Closed - not a bug', 1);
INSERT INTO events VALUES ('CCP','Closed - customer problem', 1);
INSERT INTO events VALUES ('CFX','Closed - fixed', 1);

CREATE TABLE nextproblemid (
  problemID char(8) default NULL
);

INSERT INTO nextproblemid VALUES ('G0004311');

CREATE TABLE problems (
  problemID char(8) default NULL,
  description char(32) default NULL,
  severity int(11) default NULL,
  dateReported datetime default NULL,
  dateResolved datetime default NULL,
  customerID char(8) default NULL,
  productID char(6) default NULL
);

CREATE TABLE problog (
  problemID char(8) default NULL,
  logTime datetime default NULL,
  eventID char(3) default NULL,
  comments char(200) default NULL
);

CREATE TABLE products (
  productID char(6) default NULL,
  name char(40) default NULL,
  pslead char(4) default NULL,
  pdlead char(4) default NULL,
  qalead char(4) default NULL
);

INSERT INTO products VALUES ('023500','ScoreWriter','0040','0140','0070');
INSERT INTO products VALUES ('023510','MIDI Editor','0040','0170','0090');
INSERT INTO products VALUES ('023520','Music Teacher Studio','0010','0190','0210');
INSERT INTO products VALUES ('023530','HarmonyTutor','0250','0240','0390');
INSERT INTO products VALUES ('023540','LessonMinder','0010','0190','0400');
INSERT INTO products VALUES ('023550','TuneNamer','0300','0280','0070');
INSERT INTO products VALUES ('023560','Liturgy Assistant','0080','0140','0090');
INSERT INTO products VALUES ('023570','MIDI Transposer','0040','0170','0210');
INSERT INTO products VALUES ('023580','WaveMixer','0080','0310','0390');
INSERT INTO products VALUES ('023590','OvertoneMaster','0250','0340','0400');
INSERT INTO products VALUES ('023600','iMetronome','0300','0370','0090');

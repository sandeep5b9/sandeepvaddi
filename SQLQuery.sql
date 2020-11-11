create database test;

create table `test`.`loaninfo` (
`loanpurpose` varchar(45) not null,
  `loanid` int not null,
  `loanamt` int not null,
  `doa` date not null,
  `bsstructure` varchar(45) not null,
  `biindicator` varchar(45) not null,
  `status` varchar(45) not null,
  `address` varchar(250) not null,
  `email` varchar(100) not null,
  `mobile` varchar(10) not null,
  primary key (`loanid`));
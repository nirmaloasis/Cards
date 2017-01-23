use gamestst;

set FOREIGN_KEY_CHECKS = 0;
truncate table statistics;
truncate table users;
set FOREIGN_KEY_CHECKS = 1;

insert into `users` (`user_name`, `balance`)
values
  ("pankaj", 100000),
  ("nirmal", 500000);
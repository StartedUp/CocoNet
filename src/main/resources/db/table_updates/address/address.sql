CREATE table `address` (
`id` bigint(20) not null auto_increment,
`address_line1` varchar(255) not null,
`address_line2` varchar(255) not null,
`city` varchar(50) not null,
`state` varchar(50) not null,
`country` varchar(50) not null,
`pincode` varchar(50) not null,
PRIMARY KEY(`id`)
)
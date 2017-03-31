/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Andeson
 * Created: 14/06/2016
 */

create database contato; 
use contato;

create table contato.contato(
  id int not null auto_increment, 
  nome varchar(60),
  telefone varchar(15),
  primary key (id)
);

create table contato.parente (
  id int not null auto_increment,
  nome varchar(60),
  contato int not null,
  primary key (id),
  foreign key (contato) references contato.contato (id) on delete cascade
);
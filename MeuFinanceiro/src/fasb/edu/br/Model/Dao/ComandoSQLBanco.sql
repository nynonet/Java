/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andesonjesusdemenezes
 * Created: 17/01/2019
 */

create table grupos (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome varchar(60),
  fixo boolean default false
);

create table contas (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome varchar(80),
  banco boolean default false
);

create table participantes (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome varchar(120),
  status boolean default true
);

create table lancamentos (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  participante integer not null,
  conta integer not null,
  grupo integer not null,
  data date,
  valor numeric(12,2) default 0,
  observacao varchar(255),
  integer tipo,
  foreign key(participante) references participantes (id) on update cascade,
  foreign key(conta) references contas (id) on update cascade, 
  foreign key(grupo) references grupos (id) on update cascade
);

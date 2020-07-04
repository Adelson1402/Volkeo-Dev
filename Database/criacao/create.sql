-- -----------------------------------------------------
-- Schema CONTROLE_SERVICO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS CONTROLE_SERVICO DEFAULT CHARACTER SET latin1 COLLATE latin1_general_cs ;
USE CONTROLE_SERVICO ;

create table  generator  (
   table_name  varchar(60) not null,
   value  bigint(20) not null,
  primary key ( table_name )
) engine=innodb default charset=latin1;

-- -----------------------------------------------------
-- table tb_pessoa
-- -----------------------------------------------------
create table if not exists tb_pessoa (
  id_pessoa bigint(15) not null,
  dh_criacao datetime not null,
  primary key (id_pessoa))
engine = innodb;


-- -----------------------------------------------------
-- table tab_tipo_telefone
-- -----------------------------------------------------
create table if not exists tab_tipo_telefone (
  id_tipo_telefone bigint(10) not null,
  ds_tipo varchar(45) not null,
  ds_mask varchar(45) null,
  primary key (id_tipo_telefone))
engine = innodb;


-- -----------------------------------------------------
-- table tb_telefones
-- -----------------------------------------------------
create table if not exists tb_telefones (
  id_telefones bigint(15) not null,
  descr_numero varchar(45) not null,
  fl_principal char(1) not null,
  ds_ddi varchar(10) not null,
  id_tipo_telefone bigint(10) not null,
  id_pessoa bigint(15) not null,
  primary key (id_telefones, ds_ddi, id_tipo_telefone, id_pessoa),
  index fk_tb_telefones_tab_tipo_telefone1_idx (id_tipo_telefone asc),
  unique index un_telefone_pessoa (descr_numero asc, ds_ddi asc),
  index fk_tb_telefones_tb_pessoa1_idx (id_pessoa asc),
  constraint fk_tb_telefones_tab_tipo_telefone1
    foreign key (id_tipo_telefone)
    references tab_tipo_telefone (id_tipo_telefone)
    on delete no action
    on update no action,
  constraint fk_tb_telefones_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_tipo_documento
-- -----------------------------------------------------
create table if not exists tab_tipo_documento (
  id_tipo_documento bigint(10) not null,
  descr_tipo_documento varchar(45) not null,
  cod_tipo_documento varchar(5) not null,
  fl_pessoa char(1) not null comment 'a=ambos\nf=física\nj=jurídica',
  mask_tipo_documento varchar(45) null,
  primary key (id_tipo_documento))
engine = innodb;


-- -----------------------------------------------------
-- table tab_documentos
-- -----------------------------------------------------
create table if not exists tab_documentos (
  id_documentos bigint(15) not null,
  nr_documento varchar(45) not null,
  ds_complemento varchar(45) null,
  ds_obs varchar(100) null,
  id_tp_documento bigint(10) not null,
  id_pessoa bigint(15) not null,
  primary key (id_documentos, id_tp_documento, id_pessoa),
  index fk_tab_documentos_tab_tipo_documento1_idx (id_tp_documento asc),
  index un_doc_pessoa using btree (nr_documento asc, id_tp_documento asc),
  index fk_tab_documentos_tb_pessoa1_idx (id_pessoa asc),
  constraint fk_tab_documentos_tab_tipo_documento1
    foreign key (id_tp_documento)
    references tab_tipo_documento (id_tipo_documento)
    on delete no action
    on update no action,
  constraint fk_tab_documentos_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_tp_endereco
-- -----------------------------------------------------
create table if not exists tab_tp_endereco (
  id_tp_endereco bigint(8) not null,
  ds_tp_endereco varchar(45) not null,
  primary key (id_tp_endereco))
engine = innodb;


-- -----------------------------------------------------
-- table tab_endereco
-- -----------------------------------------------------
create table if not exists tab_endereco (
  id_endereco bigint(15) not null,
  ds_logradouro varchar(100) not null,
  ds_numero varchar(8) not null,
  ds_complemento varchar(80) null,
  ds_bairro varchar(100) not null,
  ds_cidade varchar(80) not null,
  ds_cep varchar(8) not null,
  fl_principal char(1) not null,
  id_tp_endereco bigint(8) not null,
  id_pessoa bigint(15) not null,
  ds_uf varchar(2) not null,
  primary key (id_endereco, id_tp_endereco, id_pessoa),
  index fk_tab_enderecos_tab_tp_endereco1_idx (id_tp_endereco asc),
  index fk_tab_endereco_tb_pessoa1_idx (id_pessoa asc),
  constraint fk_tab_enderecos_tab_tp_endereco1
    foreign key (id_tp_endereco)
    references tab_tp_endereco (id_tp_endereco)
    on delete no action
    on update no action,
  constraint fk_tab_endereco_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_emails
-- -----------------------------------------------------
create table if not exists tab_emails (
  id_emails bigint(15) not null,
  ds_email varchar(80) not null,
  fl_principal char(1) not null,
  id_pessoa bigint(15) not null,
  primary key (id_emails, id_pessoa),
  unique index un_email_pessoa (ds_email asc),
  index fk_tab_emails_tb_pessoa1_idx (id_pessoa asc),
  constraint fk_tab_emails_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_pessoa_fisica
-- -----------------------------------------------------
create table if not exists tab_pessoa_fisica (
  id_pessoa bigint(15) not null,
  nm_nome varchar(100) not null,
  nm_sobrenome varchar(100) not null,
  cd_sexo char(1) not null,
  dh_nascimento date null,
  primary key (id_pessoa),
  constraint fk_table1_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_ramo_atividade
-- -----------------------------------------------------
create table if not exists tab_ramo_atividade (
  id_ramo_atividade bigint(15) not null,
  cd_cnae varchar(20) not null,
  ds_ramo varchar(100) not null,
  primary key (id_ramo_atividade))
engine = innodb;


-- -----------------------------------------------------
-- table tab_pessoa_juridica
-- -----------------------------------------------------
create table if not exists tab_pessoa_juridica (
  id_pessoa bigint(15) not null,
  razao_social varchar(100) not null,
  nm_fantasia varchar(100) not null,
  dh_fundacao date null,
  id_ramo_atividade bigint(15) not null,
  primary key (id_pessoa, id_ramo_atividade),
  index fk_tab_pessoa_juridica_tab_ramo_atividade1_idx (id_ramo_atividade asc),
  constraint fk_tab_pessoa_juridica_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action,
  constraint fk_tab_pessoa_juridica_tab_ramo_atividade1
    foreign key (id_ramo_atividade)
    references tab_ramo_atividade (id_ramo_atividade)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_usuario
-- -----------------------------------------------------
create table if not exists tab_usuario (
  dh_criacao datetime not null,
  fl_situacao char(1) not null,
  id_pessoa bigint(15) not null,
  nm_senha varchar(45) not null,
  primary key (id_pessoa),
  constraint fk_tab_usuario_tb_pessoa1
    foreign key (id_pessoa)
    references tb_pessoa (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_empresa_acesso
-- -----------------------------------------------------
create table if not exists tab_empresa_acesso (
  id_empresa bigint(20) not null,
  path_logotipo varchar(100) not null,
  ds_header varchar(80) not null,
  primary key (id_empresa))
engine = innodb;


-- -----------------------------------------------------
-- table tab_perfil
-- -----------------------------------------------------
create table if not exists tab_perfil (
  id_perfil bigint(10) not null,
  cod_perfil varchar(20) not null,
  ds_perfil varchar(50) not null,
  fl_situacao char(1) not null,
  id_empresa bigint(20) not null,
  primary key (id_perfil),
  index fk_tab_perfil_tab_empresa_acesso1_idx (id_empresa asc),
  constraint fk_tab_perfil_tab_empresa_acesso1
    foreign key (id_empresa)
    references tab_empresa_acesso (id_empresa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_grupo
-- -----------------------------------------------------
create table if not exists tab_grupo (
  id_grupo bigint(10) not null,
  ds_grupo varchar(80) not null,
  cd_grupo varchar(6) not null,
  fl_situacao char(1) not null,
  id_empresa bigint(20) not null,
  primary key (id_grupo, id_empresa),
  index fk_tab_grupo_tab_empresa_acesso1_idx (id_empresa asc),
  constraint fk_tab_grupo_tab_empresa_acesso1
    foreign key (id_empresa)
    references tab_empresa_acesso (id_empresa)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_perfil_grupo
-- -----------------------------------------------------
create table if not exists tab_perfil_grupo (
  id_perfil bigint(10) not null,
  id_grupo bigint(10) not null,
  fl_situacao char(1) not null,
  primary key (id_perfil, id_grupo),
  index fk_tab_perfil_grupo_tab_perfil1_idx (id_perfil asc),
  index fk_tab_perfil_grupo_tab_grupo1_idx (id_grupo asc),
  constraint fk_tab_perfil_grupo_tab_perfil1
    foreign key (id_perfil)
    references tab_perfil (id_perfil)
    on delete no action
    on update no action,
  constraint fk_tab_perfil_grupo_tab_grupo1
    foreign key (id_grupo)
    references tab_grupo (id_grupo)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_url
-- -----------------------------------------------------
create table if not exists tab_url (
  id_url bigint(15) not null,
  ds_url varchar(45) not null,
  cod_acesso varchar(200) not null,
  ds_obs varchar(255) null,
  fl_situacao char(1) not null,
  primary key (id_url),
  index idx_url_acesso (cod_acesso asc))
engine = innodb;


-- -----------------------------------------------------
-- table tab_menu
-- -----------------------------------------------------
create table if not exists tab_menu (
  id_menu bigint(15) not null,
  ds_menu varchar(45) not null,
  lbl_menu varchar(100) not null,
  fl_situacao char(1) not null,
  nr_ordem int not null,
  id_url bigint(15) null,
  tab_menu_id_menu bigint(15) null,
  primary key (id_menu),
  index fk_tab_menu_tab_url1_idx (id_url asc),
  index fk_tab_menu_tab_menu1_idx (tab_menu_id_menu asc),
  constraint fk_tab_menu_tab_url1
    foreign key (id_url)
    references tab_url (id_url)
    on delete no action
    on update no action,
  constraint fk_tab_menu_tab_menu1
    foreign key (tab_menu_id_menu)
    references tab_menu (id_menu)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_funcionalidade
-- -----------------------------------------------------
create table if not exists tab_funcionalidade (
  id_funcionalidade bigint(15) not null,
  ds_funcionalidade varchar(45) not null,
  fl_situacao char(1) not null,
  id_menu bigint(15) null,
  primary key (id_funcionalidade),
  index fk_tab_funcionalidade_tab_menu1_idx (id_menu asc),
  constraint fk_tab_funcionalidade_tab_menu1
    foreign key (id_menu)
    references tab_menu (id_menu)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_funcionalidade_url
-- -----------------------------------------------------
create table if not exists tab_funcionalidade_url (
  id_url bigint(15) not null,
  id_funcionalidade bigint(15) not null,
  primary key (id_url, id_funcionalidade),
  index fk_tab_funcionalidade_url_tab_funcionalidade1_idx (id_funcionalidade asc),
  constraint fk_tab_funcionalidade_url_tab_url1
    foreign key (id_url)
    references tab_url (id_url)
    on delete no action
    on update no action,
  constraint fk_tab_funcionalidade_url_tab_funcionalidade1
    foreign key (id_funcionalidade)
    references tab_funcionalidade (id_funcionalidade)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_func_grupo
-- -----------------------------------------------------
create table if not exists tab_func_grupo (
  id_funcionalidade bigint(15) not null,
  id_grupo bigint(10) not null,
  fl_situacao char(1) not null,
  primary key (id_funcionalidade, id_grupo),
  index fk_table1_tab_grupo1_idx (id_grupo asc),
  constraint fk_table1_tab_funcionalidade1
    foreign key (id_funcionalidade)
    references tab_funcionalidade (id_funcionalidade)
    on delete no action
    on update no action,
  constraint fk_table1_tab_grupo1
    foreign key (id_grupo)
    references tab_grupo (id_grupo)
    on delete no action
    on update no action)
engine = innodb;


-- -----------------------------------------------------
-- table tab_usuario_perfil
-- -----------------------------------------------------
create table if not exists tab_usuario_perfil (
  id_perfil bigint(10) not null,
  id_pessoa bigint(15) not null,
  fl_situacao char(1) not null,
  primary key (id_perfil, id_pessoa),
  index fk_tab_usuario_perfil_tab_usuario1_idx (id_pessoa asc),
  constraint fk_tab_usuario_perfil_tab_perfil1
    foreign key (id_perfil)
    references tab_perfil (id_perfil)
    on delete no action
    on update no action,
  constraint fk_tab_usuario_perfil_tab_usuario1
    foreign key (id_pessoa)
    references tab_usuario (id_pessoa)
    on delete no action
    on update no action)
engine = innodb;







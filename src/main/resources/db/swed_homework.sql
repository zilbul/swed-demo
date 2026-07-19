CREATE OR REPLACE PACKAGE swed_homework IS

  -- Author  : ZBULO
  -- Created : 14/07/2026 20:53:35
  -- Purpose : homework

  TYPE invoice IS RECORD(
    invoice_id   NUMBER,
    invoice_date DATE);

  TYPE invoices IS REF CURSOR RETURN invoice;

  -- returns age bracket as formatted text e.g. 'You are middle-aged'
  FUNCTION get_age_bracket(par_age IN NUMBER) RETURN VARCHAR2;

  -- returns pi value rounded with precision
  FUNCTION get_pi(par_precision IN NUMBER) RETURN NUMBER;

  -- returns all unpaid invoices
  FUNCTION get_unpaid_invoices RETURN invoices;

END swed_homework;

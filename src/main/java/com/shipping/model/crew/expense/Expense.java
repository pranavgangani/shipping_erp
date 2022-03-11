package com.shipping.model.crew.expense;

import com.shipping.model.crew.PaymentMethod;

public class Expense {
	private int expenseId;
	private String expenseName;
	private int expenseCategoryId;
	private double amount;
	private String note;
	private PaymentMethod paymentMethod;
	private ExpenseStatus expenseStatus;
	
}

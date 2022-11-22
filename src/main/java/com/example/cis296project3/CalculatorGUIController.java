package com.example.cis296project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.EmptyStackException;
import java.util.Stack;

public class CalculatorGUIController {
	@FXML
	private Text stackDisplay;				//display text
	private boolean isClear = true;			//flag for just cleared input

	private String input = "";				//string to track input

	private Stack<String> stringStack = new Stack<>(); //stack for calculation


	@FXML
	private void calcInputCallback(ActionEvent e) {
		final Node source = (Node) e.getSource();
		if (source instanceof Button) {
			try {
				switch (((Button) source).getText()) {
					//Case for space input
					case "⎵": {
						input += " ";
						stackDisplay.setText(stackDisplay.getText() + " ");
						break;
					}
					//Case for clear input
					case "C": {
						input = "";
						stackDisplay.setText("0");
						isClear = true;
						break;
					}
					//Case for equals input
					case "=": {
						String inputs[];
						isClear = true;
						inputs = input.split(" ");
						//Runs through user input and calculates the result
						for (int i = 0; i < inputs.length; i++) {
							switch (inputs[i]) {
								//Case for addition input
								case "+": {
									double x = Double.parseDouble(stringStack.pop());
									double y = Double.parseDouble(stringStack.pop());
									double res = x + y;
									stringStack.push("" + res);
									break;
								}
								//Case for subtraction input
								case "–": {
									double x = Double.parseDouble(stringStack.pop());
									double y = Double.parseDouble(stringStack.pop());
									double res = y - x;
									stringStack.push("" + res);
									break;

								}
								//Case for multiplication
								case "x": {
									double x = Double.parseDouble(stringStack.pop());
									double y = Double.parseDouble(stringStack.pop());
									double res = x * y;
									stringStack.push("" + res);

									break;
								}
								//Case for division
								case "/": {
									double x = Double.parseDouble(stringStack.pop());
									if (x == 0) {
										throw new EmptyStackException();
									}
									double y = Double.parseDouble(stringStack.pop());
									double res = y / x;
									stringStack.push("" + res);
									break;
								}
								//Default case; pushes doubles to the stack
								default: {
									stringStack.push(inputs[i]);
									break;
								}
							}
						}
						//remove decimal point if zero
						String result = stringStack.pop();
						if (result.endsWith(".0")) {
							result = result.substring(0, result.length() - 2);
						}
						stackDisplay.setText("" + result);
						stringStack.clear();
						input = "";
						break;
					}
					default: {
						if (isClear) { //if isClear flag is set the next input overrides what is currently in the display window
							stackDisplay.setText(((Button) source).getText());
							isClear = false;
						} else {
							stackDisplay.setText(stackDisplay.getText() + ((Button) source).getText());
						}
						input += ((Button) source).getText();
						break;
					}
				}
			} catch (EmptyStackException emptyStackException) { //catch when the stack is empty mid-operation and display error
				stackDisplay.setText("Error");
				stringStack.clear();
				input = "";
			}
		}
	}
}
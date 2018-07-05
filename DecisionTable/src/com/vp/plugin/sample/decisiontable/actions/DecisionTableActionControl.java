package com.vp.plugin.sample.decisiontable.actions;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDTBDecisionTableEditorDiagramUIModel;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.model.IDTBAction;
import com.vp.plugin.model.IDTBCondition;
import com.vp.plugin.model.IDTBDecisionTable;
import com.vp.plugin.model.IDTBRule;
import com.vp.plugin.model.IDTBRuleActionValue;
import com.vp.plugin.model.IDTBRuleConditionValue;
import com.vp.plugin.model.factory.IModelElementFactory;

public class DecisionTableActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// Obtain DiagramManager and create Decision Table Diagram 
		DiagramManager dm = ApplicationManager.instance().getDiagramManager();
		IDTBDecisionTableEditorDiagramUIModel decisionTableDiagram = (IDTBDecisionTableEditorDiagramUIModel) dm.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_DTB_DECISION_TABLE_EDITOR_DIAGRAM);		
		
		// Obtain Model Element Factory
		IModelElementFactory factory = IModelElementFactory.instance();
		
		// Create Decision Table model 
		// and clear its default condition, action and rule
		IDTBDecisionTable decisionTable = factory.createDTBDecisionTable();
		decisionTable.removeConditionByIndex(0);
		decisionTable.removeActionByIndex(0);
		decisionTable.removeRuleByIndex(0);
		// Assign the decision table to diagram
		decisionTableDiagram.setDecisionTableModelAddress(decisionTable.getAddress());
		
		// Create conditions and assign to decision table
		IDTBCondition condAddressProvided = factory.createDTBCondition();
		condAddressProvided.setName("Address proof provided");
		decisionTable.addCondition(condAddressProvided);
		
		IDTBCondition condIdentityProvided = factory.createDTBCondition();
		condIdentityProvided.setName("Identity proof provided");
		decisionTable.addCondition(condIdentityProvided);
		
		IDTBCondition condLoanLessThanSalary = factory.createDTBCondition();
		condLoanLessThanSalary.setName("Loan amount < monthly salary");
		decisionTable.addCondition(condLoanLessThanSalary);
		
		IDTBCondition condLoanMoreThanSalary = factory.createDTBCondition();
		condLoanMoreThanSalary.setName("Loan amount >= monthly salary");
		decisionTable.addCondition(condLoanMoreThanSalary);
		
		IDTBCondition condPurpose = factory.createDTBCondition();
		condPurpose.setName("Loan purpose");
		decisionTable.addCondition(condPurpose);
		
		IDTBCondition condHomeOwner = factory.createDTBCondition();
		condHomeOwner.setName("Home owner?");
		decisionTable.addCondition(condHomeOwner);
		
		// Create actions and assign to decision table
		IDTBAction actApprove = factory.createDTBAction();
		actApprove.setName("Approve loan request immediately");
		decisionTable.addAction(actApprove);
		
		IDTBAction actReview = factory.createDTBAction();
		actReview.setName("Review loan request manually");
		decisionTable.addAction(actReview);
		
		IDTBAction actReject = factory.createDTBAction();
		actReject.setName("Reject loan request");
		decisionTable.addAction(actReject);
		
		// Set the width of the conditions and actions column
		decisionTable.setConditionActionWidth(320);
		
		// Create rules and specify its width
		IDTBRule rule1 = factory.createDTBRule();
		decisionTable.addRule(rule1);
		rule1.setWidth(50);
		
		// Specify conditions and values and apply to rule
		IDTBRuleConditionValue rule1Con = factory.createDTBRuleConditionValue();
		rule1Con.setRule(rule1);
		rule1Con.setCondition(condAddressProvided);
		rule1Con.setName("N");
		decisionTable.addRuleConditionValue(rule1Con);
		
		// Specify action for the rule
		IDTBRuleActionValue rule1Act = factory.createDTBRuleActionValue();
		rule1Act.setRule(rule1);
		rule1Act.setAction(actReject);
		rule1Act.setName("X");
		decisionTable.addRuleActionValue(rule1Act);
				
		IDTBRule rule2 = factory.createDTBRule();
		decisionTable.addRule(rule2);
		rule2.setWidth(50);
		
		IDTBRuleConditionValue rule2Con = factory.createDTBRuleConditionValue();
		rule2Con.setRule(rule2);
		rule2Con.setCondition(condIdentityProvided);
		rule2Con.setName("N");
		decisionTable.addRuleConditionValue(rule2Con);
		
		IDTBRuleActionValue rule2Act = factory.createDTBRuleActionValue();
		rule2Act.setRule(rule2);
		rule2Act.setAction(actReject);
		rule2Act.setName("X");
		decisionTable.addRuleActionValue(rule2Act);
		
		IDTBRule rule3 = factory.createDTBRule();
		decisionTable.addRule(rule3);
		rule3.setWidth(50);
		
		IDTBRuleConditionValue rule3Con1 = factory.createDTBRuleConditionValue();
		rule3Con1.setRule(rule3);
		rule3Con1.setCondition(condAddressProvided);
		rule3Con1.setName("Y");
		decisionTable.addRuleConditionValue(rule3Con1);
		
		IDTBRuleConditionValue rule3Con2 = factory.createDTBRuleConditionValue();
		rule3Con2.setRule(rule3);
		rule3Con2.setCondition(condIdentityProvided);
		rule3Con2.setName("Y");
		decisionTable.addRuleConditionValue(rule3Con2);

		IDTBRuleConditionValue rule3Con3 = factory.createDTBRuleConditionValue();
		rule3Con3.setRule(rule3);
		rule3Con3.setCondition(condLoanLessThanSalary);
		rule3Con3.setName("Y");
		decisionTable.addRuleConditionValue(rule3Con3);
		
		IDTBRuleActionValue rule3Act = factory.createDTBRuleActionValue();
		rule3Act.setRule(rule3);
		rule3Act.setAction(actApprove);
		rule3Act.setName("X");
		decisionTable.addRuleActionValue(rule3Act);
		
		IDTBRule rule4 = factory.createDTBRule();
		decisionTable.addRule(rule4);
		rule4.setWidth(130);
		
		IDTBRuleConditionValue rule4Con1 = factory.createDTBRuleConditionValue();
		rule4Con1.setRule(rule4);
		rule4Con1.setCondition(condAddressProvided);
		rule4Con1.setName("Y");
		decisionTable.addRuleConditionValue(rule4Con1);
		
		IDTBRuleConditionValue rule4Con2 = factory.createDTBRuleConditionValue();
		rule4Con2.setRule(rule4);
		rule4Con2.setCondition(condIdentityProvided);
		rule4Con2.setName("Y");
		decisionTable.addRuleConditionValue(rule4Con2);

		IDTBRuleConditionValue rule4Con3 = factory.createDTBRuleConditionValue();
		rule4Con3.setRule(rule4);
		rule4Con3.setCondition(condPurpose);
		rule4Con3.setName("Home purchase");
		decisionTable.addRuleConditionValue(rule4Con3);

		IDTBRuleConditionValue rule4Con4 = factory.createDTBRuleConditionValue();
		rule4Con4.setRule(rule4);
		rule4Con4.setCondition(condHomeOwner);
		rule4Con4.setName("Y");
		decisionTable.addRuleConditionValue(rule4Con4);
		
		IDTBRuleActionValue rule4Act = factory.createDTBRuleActionValue();
		rule4Act.setRule(rule4);
		rule4Act.setAction(actApprove);
		rule4Act.setName("X");
		decisionTable.addRuleActionValue(rule4Act);
		
		IDTBRule rule5 = factory.createDTBRule();
		decisionTable.addRule(rule5);
		rule5.setWidth(70);
		
		IDTBRuleConditionValue rule5Con1 = factory.createDTBRuleConditionValue();
		rule5Con1.setRule(rule5);
		rule5Con1.setCondition(condAddressProvided);
		rule5Con1.setName("Y");
		decisionTable.addRuleConditionValue(rule5Con1);
		
		IDTBRuleConditionValue rule5Con2 = factory.createDTBRuleConditionValue();
		rule5Con2.setRule(rule5);
		rule5Con2.setCondition(condIdentityProvided);
		rule5Con2.setName("Y");
		decisionTable.addRuleConditionValue(rule5Con2);

		IDTBRuleConditionValue rule5Con3 = factory.createDTBRuleConditionValue();
		rule5Con3.setRule(rule5);
		rule5Con3.setCondition(condLoanMoreThanSalary);
		rule5Con3.setName("Y");
		decisionTable.addRuleConditionValue(rule5Con3);

		IDTBRuleConditionValue rule5Con4 = factory.createDTBRuleConditionValue();
		rule5Con4.setRule(rule5);
		rule5Con4.setCondition(condPurpose);
		rule5Con4.setName("Pay tax");
		decisionTable.addRuleConditionValue(rule5Con4);

		IDTBRuleActionValue rule5Act = factory.createDTBRuleActionValue();
		rule5Act.setRule(rule5);
		rule5Act.setAction(actApprove);
		rule5Act.setName("X");
		decisionTable.addRuleActionValue(rule5Act);		

		IDTBRule rule6 = factory.createDTBRule();
		decisionTable.addRule(rule6);
		rule6.setWidth(60);
		
		IDTBRuleConditionValue rule6Con1 = factory.createDTBRuleConditionValue();
		rule6Con1.setRule(rule6);
		rule6Con1.setCondition(condAddressProvided);
		rule6Con1.setName("Y");
		decisionTable.addRuleConditionValue(rule6Con1);
		
		IDTBRuleConditionValue rule6Con2 = factory.createDTBRuleConditionValue();
		rule6Con2.setRule(rule6);		
		rule6Con2.setCondition(condIdentityProvided);
		rule6Con2.setName("Y");
		decisionTable.addRuleConditionValue(rule6Con2);

		IDTBRuleConditionValue rule6Con3 = factory.createDTBRuleConditionValue();
		rule6Con3.setRule(rule6);
		rule6Con3.setCondition(condLoanMoreThanSalary);
		rule6Con3.setName("Y");
		decisionTable.addRuleConditionValue(rule6Con3);

		IDTBRuleConditionValue rule6Con4 = factory.createDTBRuleConditionValue();
		rule6Con4.setRule(rule6);
		rule6Con4.setCondition(condPurpose);
		rule6Con4.setName("Other");
		decisionTable.addRuleConditionValue(rule6Con4);

		IDTBRuleActionValue rule6Act = factory.createDTBRuleActionValue();
		rule6Act.setRule(rule6);
		rule6Act.setAction(actReview);
		rule6Act.setName("X");
		decisionTable.addRuleActionValue(rule6Act);		
		
		// Show up the diagram
		dm.openDiagram(decisionTableDiagram);				
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}

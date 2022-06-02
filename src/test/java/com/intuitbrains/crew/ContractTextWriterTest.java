package com.intuitbrains.crew;

import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.crew.ContractRuleRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.common.document.Insurance;
import com.intuitbrains.model.common.document.Passport;
import com.intuitbrains.model.common.document.category.DocumentCategory;
import com.intuitbrains.model.common.document.category.DocumentPool;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.crew.ContractRule;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.service.common.SequenceGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class ContractTextWriterTest {
    @Autowired
    private ContractRuleRepository contractRuleDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Test
    void addContractRules() {
        ContractRule rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.JOINING_DOCS);
        contractRuleDao.insert(rule);

        rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.JOINING_DOCS);

        List<String> body = new ArrayList<>();
        body.add("I fully agree that I have carried all the certificates & documents as mentioned above at the time of joining.");
        rule.setRuleBody(body);
        contractRuleDao.insert(rule);

        rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.BRIEFING);
        body = new ArrayList<>();
        body.add("1) I have been completely briefed by the Manning Company on all the above topics and same has been fully understood by me.");
        body.add("2) I have gone through the terms & conditions of RBSA/CBA or Special ITF agreement applicable clearly understood & agreed.");
        body.add("3) I have been briefed about normal working hours on board at an average of 9.5 hours per day.");
        rule.setRuleBody(body);
        contractRuleDao.insert(rule);

        rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.DOCS_HANDED_OVER);
        body = new ArrayList<>();
        body.add("1) I fully agree that I have received all the documents as mentioned above from <vessleName>");
        body.add("2) I have gone through the terms & conditions of RBSA/CBA or Special ITF/NUSI agreement applicable clearly understood & agreed.");
        body.add("3) No Cash On-Board policy has been briefed to me.");
        rule.setRuleBody(body);
        contractRuleDao.insert(rule);

        rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.DRUG_ALCOHOL_DECLARATION);
        List<String> head = new ArrayList<>();
        head.add("I, <name> a Seafarer contracted for service on board <vesselName> through Owner's agent <vesselOwner>");
        head.add("hereby declare:");
        head.add("A. That I am not a habitual user of any other drugs other than at times when they have been prescribed to me by a registered medical practitioner.<br>" +
                "A history of such controlled drug usage, if any, has been declared by me at the time of pre-employment medical.");
        head.add("B. I will not take any drugs whilst serving onboard unless prescribed by ship's medical Officer or a medical practitioner appointed by the Master or his agents.");
        head.add("C. I will have no objection to submitting myself to random testing for usage of drugs, or misuse of alcohol which may be ordered by the Master in keeping withing the scope " +
                "of Company's drug and alcohol policy.");
        head.add("D. I have been made fully aware of Company's policy on drug and alcohol abuse and undertake to abide by it");
        head.add("E. I agree that possession, use and trafficking of Drugs and breach of Company's Drug and Alcohol Policy will be just causes for termination of my employment with repatriation at my costs.");

        body = new ArrayList<>();
        body.add("I fully agree to co-operate with U.S. Drug Enforecement Agency, with regards to the implementation of the provisions contained in the Sea Carrier Security Manual. Above declaration has been made " +
                " by me without duress and of my own free will on this day of ");
        rule.setRuleBody(body);
        rule.setRuleHeading(head);
        contractRuleDao.insert(rule);

        rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.OBJ_MATERIAL_DECLARATION);
        head = new ArrayList<>();
        head.add("I, <name> a Seafarer contracted for service on board <vesselName> through Owner's agent <vesselOwner>");
        head.add("hereby declare:");
        head.add("A. I will not carry any of objectionable materials such as pedophile or hard Pornographic Movies on board through my personal laptop " +
                "or through any other electronic devices.");
        head.add("B. I have been made fully aware of Company's policy on Pornographic Material and undertake to abide by it.");
        head.add("C. I agree that possession of such kind of objectionable material and breach of Company's policy will be just causes for termination of my employment " +
                "with repatriation at my costs and ready to take the punishment given to me for my offence.");

        body = new ArrayList<>();
        body.add("Above declaration has been made by me without duress and of my own free will on this day of ");
        rule.setRuleBody(body);
        rule.setRuleHeading(head);
        contractRuleDao.insert(rule);

        rule = new ContractRule();
        rule.setId(sequenceGenerator.generateSequence(ContractRule.SEQUENCE_NAME));
        rule.setRuleType(ContractRule.RuleType.SIGNON_DECLARATION);
        head = new ArrayList<>();
        head.add("I, <name> a Seafarer contracted for service on board <vesselName> through Owner's agent <vesselOwner>");
        head.add("herewith confirm that I have read and understood the Code of Conduct of the Company, and that I will show the commitment to behave as per the " +
                "expectations laid out in the code. I understand that, should I choose not to follow the expected behaviours, this can result in disciplinary " +
                "procedures being actioned against me.");

        head.add("I will comply and ALWAYS follow the 10 Golder Rules set by <vesselOwner> as my commitment to safety to protect myself, my colleagues and the company");

        head.add("I will:");
        head.add("1. Use Permists to Work to execute jobs safely.");
        head.add("2. LOTO: Isolate systems and Target Zero Energy");
        head.add("3. Say No to Overriding Systems, Equipments and Procedures");
        head.add("4. Plan my lift and control work area");
        head.add("5. Be aware of Hazards and Control measures");
        head.add("6. Intervene and Stop unsage acts and conditions");
        head.add("7. Conduct and actively participate in Toolbox Talks");
        head.add("8. Maintain Good Housekeeping");
        head.add("9. Protect myself wiht correct PPE");
        head.add("10. Never abuse drug and alcohol");

        head.add("");
        head.add("");
        head.add("");
        head.add("I also declare:");
        head.add("A. That I am not a habitual user of any other drugs other than at times when they have been prescribed to me by a registered medical practitioner.<br>" +
                "A history of such controlled drug usage, if any, has been declared by me at the time of pre-employment medical.");
        head.add("B. I will not take any drugs whilst serving onboard unless prescribed by ship's medical Officer or a medical practitioner appointed by the Master or his agents.");
        head.add("C. I will have no objection to submitting myself to random testing for usage of drugs, or misuse of alcohol which may be ordered by the Master in keeping withing the scope " +
                "of Company's drug and alcohol policy.");
        head.add("D. I have been made fully aware of Company's policy on drug and alcohol abuse and undertake to abide by it");
        head.add("E. I agree that possession, use and trafficking of Drugs and breach of Company's Drug and Alcohol Policy will be just causes for termination of my employment with repatriation at my costs.");

        body = new ArrayList<>();
        body.add("I also declare:");
        body.add("The above declaration has been made by me without duress and of my own free will on this day of ");
        rule.setRuleHeading(head);
        rule.setRuleBody(body);
        contractRuleDao.insert(rule);
    }
}

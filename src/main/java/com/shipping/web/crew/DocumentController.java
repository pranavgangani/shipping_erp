package com.shipping.web.crew;

import com.shipping.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.dao.crew.DocumentRepository;
import com.shipping.dao.crew.CrewSubDocumentCategoryRepository;
import com.shipping.model.crew.Rank;
import com.shipping.model.crew.RankCategory;
import com.shipping.model.crew.RankSubCategory;
import com.shipping.model.vessel.VesselSubType;
import com.shipping.model.vessel.VesselType;
import com.shipping.model.common.DurationType;
import com.shipping.model.crew.Document;
import com.shipping.model.crew.DocumentCategory;
import com.shipping.model.crew.DocumentMatrix;
import com.shipping.model.crew.DocumentSubCategory;
import com.shipping.service.common.SequenceGeneratorService;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/settings")
public class DocumentController {
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	@Autowired
	private DocumentRepository docRepository;
	@Autowired
	private CrewSubDocumentCategoryRepository subDocumentCategoryDao;

	@GetMapping(value = "/crew_doc_category_list")
	public ModelAndView crewDocCategoryList(Model model) {
		ModelAndView mv = new ModelAndView("settings/crew_doc_category_list");
		mv.addObject("docCategoryList", DocumentCategory.getList());
		return mv;
	}
	@GetMapping(value = "/add_crew_doc_sub_category")
	public ModelAndView addDocSubCategory(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_crew_doc_sub_category");
		mv.addObject("docCategoryList", DocumentCategory.getList());
		return mv;
	}
	@GetMapping(value = "/crew_doc_sub_category_list")
	public ModelAndView crewDocSubCategoryList(Model model) {
		ModelAndView mv = new ModelAndView("settings/crew_doc_sub_category_list");
		mv.addObject("docCategoryList", DocumentCategory.getList());
		mv.addObject("subDocumentCategoryList", subDocumentCategoryDao.findAll());
		return mv;
	}
	@PostMapping(value = "/add_crew_doc_sub_category")
	public ModelAndView addCrewDocSubCategory(
			@RequestParam("subCatName") String subCatName,
			@RequestParam("categoryId") int categoryId) {
		ModelAndView mv = new ModelAndView("redirect:/settings/crew_doc_sub_category_list");

		DocumentSubCategory subCat = new DocumentSubCategory();
		subCat.setId(sequenceGenerator.generateSequence(DocumentSubCategory.SEQUENCE_NAME));
		subCat.setName(subCatName);
		subCat.setDocumentCategory(DocumentCategory.createFromId(categoryId));
		subCat.setValid(true);
			
		subDocumentCategoryDao.insert(subCat);
		long subCatId = subCat.getId();
		System.out.println("New subCatId ---> " + subCatId);
		mv.addObject("subCatId", subCatId);
		return mv;
	}
	
	@GetMapping(value = "/add_doc_certification")
	public ModelAndView addDocTraining(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_certification");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		mv.addObject("durationTypes", DurationType.getList());
		return mv;
	} 
	
	@GetMapping(value = "/add_doc_license")
	public ModelAndView addDocLicense(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_license");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		return mv;
	}
	
	@GetMapping(value = "/add_doc_declaration")
	public ModelAndView addDocDeclaration(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_declaration");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		return mv;
	}
	@GetMapping(value = "/add_doc_passport")
	public ModelAndView addDocPassport(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_passport");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		return mv;
	}
	@GetMapping(value = "/add_doc_visa")
	public ModelAndView addDocVisa(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_visa");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		return mv;
	}
	@GetMapping(value = "/add_doc_medical")
	public ModelAndView addDocMedical(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_medical");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		return mv;
	}
	@GetMapping(value = "/add_doc_other")
	public ModelAndView addDocO(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_doc_other");
		mv.addObject("vesselTypeList", VesselType.getList());
		mv.addObject("vesselSubTypeList", VesselSubType.getList());
		mv.addObject("rankCategoryList", RankCategory.getList());
		mv.addObject("rankSubCategoryList", RankSubCategory.getList());
		mv.addObject("rankList", Rank.getList());
		return mv;
	}

	@PostMapping(value = "/add_doc_certification")
	public ModelAndView addCertification(
			@RequestParam("certDuration") int certDuration,
			@RequestParam("durationTypeId") int durationTypeId,
			@RequestParam("certName") String certName,
			@RequestParam("certType") String certType,
			@RequestParam("regulationDetails") String regulationDetails,
			@RequestParam("chapterDetails") String chapterDetails,
			@RequestParam("sectionDetails") String sectionDetails,
			@RequestParam("isMandatory") String isMandatory,
			@RequestParam("isPaid") String isPaid,
			@RequestParam("isPhysical") String isPhysical,
			@RequestParam("isRecertRequired") String isRecertRequired,
			@RequestParam("certDesc") String certDesc,

			@RequestParam("chk_vesselTypeId") String[] vesselTypes,
			@RequestParam("chk_vesselSubTypeId") String[] vesselSubTypes,
			@RequestParam("chk_rankCategoryId") String[] rankCategories,
			@RequestParam("chk_rankSubCategoryId") String[] rankSubCategories,
			@RequestParam("chk_rankId") String[] ranks,
			@RequestParam("papPoints")int pap) {
		ModelAndView mv = new ModelAndView("redirect:/settings/certifications");
		System.out.println("certName: " + certName);

		Document cert = new Document();
		cert.setId(sequenceGenerator.generateSequence(Document.SEQUENCE_NAME));
		cert.setName(certName);
		cert.setDesc(certDesc);
		cert.setDocType(certType);
		cert.setRegulation(regulationDetails);
		cert.setSectionTable(sectionDetails);
		cert.setChapter(chapterDetails);
		cert.setValidity(certDuration);
		cert.setDurationType(DurationType.createFromId(durationTypeId));
		cert.setPap(pap);
		cert.setDocCategory(DocumentCategory.ON_BOARDING);
		cert.setDocSubCategory(subDocumentCategoryDao.findById(12L).get());
		cert.setRecertRequired(ParamUtil.parseBoolean(isRecertRequired, false));
		cert.setPhysical(ParamUtil.parseBoolean(isPhysical, false));
		cert.setPaid(ParamUtil.parseBoolean(isPaid, false));
		cert.setMandatory(ParamUtil.parseBoolean(isMandatory, false));
		DocumentMatrix docMatrix = new DocumentMatrix();

		//Arrays.stream(vesselTypes).forEach(o->Integer.parseInt());
		//docMatrix.setVesselTypeIds(new ArrayList<Integer>(Arrays.asList(vesselTypes)));
		cert.setDocumentMatrix(docMatrix);
		docRepository.insert(cert);
		long docId = cert.getId();
		mv.addObject("docId", docId);
		return mv;
	}
	
	/*@GetMapping(value = "/certifications")
	public ModelAndView certList(Model model) {
		ModelAndView mv = new ModelAndView("settings/certification_list");
		List<Document> list = docRepository.findAll();
		list.forEach(c->{		
			if(c.getRankId()>0) c.setRank(Rank.createFromId(c.getRankId()));
			if(c.getRankSubCategoryId()>0) c.setRankSubCategory(RankSubCategory.createFromId(c.getRankSubCategoryId()));
			if(c.getRankCategoryId()>0) c.setRankCategory(RankCategory.createFromId(c.getRankCategoryId()));
		});
		
		mv.addObject("list", list);
		return mv;
	}*/

}

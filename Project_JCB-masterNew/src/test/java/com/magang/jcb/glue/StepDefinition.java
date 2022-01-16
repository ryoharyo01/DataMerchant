package com.magang.jcb.glue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.magang.jcb.configs.AutomationFrameworkConfigJava;
import com.magang.jcb.drivers.DriverSingleton;
import com.magang.jcb.pages.CompletedPage;
import com.magang.jcb.pages.DashboardPages;
import com.magang.jcb.pages.LoginPages;
import com.magang.jcb.pages.MasterAreaPages;
import com.magang.jcb.pages.MasterKotaPages;
import com.magang.jcb.pages.MasterUserPages;
import com.magang.jcb.pages.ReportPage;
import com.magang.jcb.pages.VisitOtherPage;
import com.magang.jcb.pages.VisitPage;
import com.magang.jcb.pages.WorklistAddPage;
import com.magang.jcb.pages.WorklistPage;
import com.magang.jcb.utils.ConfigurationProperties;
import com.magang.jcb.utils.Constans;
import com.magang.jcb.utils.GetScreenShot;
import com.magang.jcb.utils.TestCases;
import com.magang.jcb.utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfigJava.class)
public class StepDefinition {
	private WebDriver driver;
	private LoginPages login;
	private DashboardPages db;
	private MasterUserPages user;
	private MasterKotaPages kota;
	private MasterAreaPages area;
	private ReportPage reportPage;
	private CompletedPage completedPage;
	WorklistPage worklistPage;
	VisitPage visitPage;
	VisitOtherPage otherPage;
	WorklistAddPage addPage;
	TestCases[] testCases;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");

	@Autowired
	ConfigurationProperties configProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		login = new LoginPages();
		reportPage = new ReportPage();
		completedPage = new CompletedPage();
		worklistPage = new WorklistPage();
		visitPage = new VisitPage();
		otherPage = new VisitOtherPage();
		addPage = new WorklistAddPage();
		testCases = TestCases.values();
		this.extentTest = report.startTest(testCases[Utility.testCount].getTestName());
		Utility.testCount++;
	}

	// ============================ Login Activity =======================================

	@Given("^Menampilkan form login")
	public void Menampilkan_form_login() {
		driver = DriverSingleton.getDriver();
		driver.get(Constans.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constans.URL);
	}

	@When("^Mengisi username")
	public void Mengisi_username() {
		login.inputUsername(configProperties.getUsername());
		extentTest.log(LogStatus.PASS, "Mengisi username");
	}

	@When("^Mengisi Password")
	public void Mengisi_Password() {
		login.inputPassword(configProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Mengisi Password");
	}

	@When("^Login ke sistem JCB")
	public void Login_ke_sistem_JCB() {
		login.clickButtonLogin();
		extentTest.log(LogStatus.PASS, "Login ke sistem JCB");
	}

	@Then("^Muncul pesan selamat datang superadmin2")
	public void Muncul_pesan_selamat_datang_superadmin2() {
		assertEquals(configProperties.getMessageLogin(), login.getMessageText());
		extentTest.log(LogStatus.PASS, "Muncul pesan selamat datang superadmin2");
	}
	
	//============================ Dashboard Activity ============================
		@When("^Menuju halaman dashboard")
		public void Menuju_halaman_dashboard() {
			db.gotoDashboardPage();
			extentTest.log(LogStatus.PASS,"Menuju halaman dashboard");
		}
		
		@When("^Menampilkan jumlah monthly visit")
		public void Menampilkan_jumlah_monthly_visit() {
			assertEquals(configProperties.getM1(), db.getMonthly());
			extentTest.log(LogStatus.PASS,"Menampilkan jumlah monthly visit");
		}
		
		@When("^Menampilkan jumlah unvisit")
		public void Menampilkan_jumlah_unvisit() {
			assertEquals(configProperties.getM2(), db.getUnvisit());
			extentTest.log(LogStatus.PASS,"Menampilkan jumlah unvisit");
		}
		
		@When("^Menampilkan jumlah monthly price")
		public void Menampilkan_jumlah_monthly_price() {
			assertEquals(configProperties.getM3(), db.getMonthlyPrice());
			extentTest.log(LogStatus.PASS, "Menampilkan jumlah monthly price");
		}
		
		@When("^Menampilkan jumlah total price")
		public void Menampilkan_jumlah_total_price() {
			assertEquals(configProperties.getM4(), db.getTotalPrice());
			extentTest.log(LogStatus.PASS, "Menampilkan jumlah total price");
		}
		
		@Then("^Menampilkan data table summary by area")
		public void Menampilkan_data_table_summary_by_area() {
			assertEquals(configProperties.getM5(), db.getSummary());
			extentTest.log(LogStatus.PASS, "Menampilkan data table summary by area");
		}
		
		//============================ Master User Activity ==========================
		@When("^Menampilkan dropdown menu master")
		public void Menampilkan_dropdown_menu_master(){
			user.gotoMaster();
			extentTest.log(LogStatus.PASS, "Menampilkan dropdown menu master");
		}
		
		@When("^Menampilkan data table user")
		public void Menampilkan_data_table_user() {
			user.gotoUser();
			extentTest.log(LogStatus.PASS, "Menampilkan data table user");
		}
		
		
		@When("^Menampilkan form tambah data user")
		public void Menampilkan_form_tambah_data_user() {
			user.clickBtnAdd();
			extentTest.log(LogStatus.PASS, "Menampilkan form tambah data user");
		}
		
		@When("^Mengisi NIK")
		public void Mengisi_NIK() {
			user.inputNik(configProperties.getNik());
			extentTest.log(LogStatus.PASS, "Mengisi NIK");
		}
		
		@When("^Mengisi nama")
		public void Mengisi_nama() {
			user.inputName(configProperties.getName());
			extentTest.log(LogStatus.PASS, "Mengisi nama");
		}
		
		@When("^Mengisi username user")
		public void UMengisi_username() {
			user.inputUsername(configProperties.getUsernameU());
			extentTest.log(LogStatus.PASS, "Mengisi username");
		}
		
		@When("^Mengisi password user")
		public void UMengisi_Password() {
			user.inputPassword(configProperties.getPasswordU());
			extentTest.log(LogStatus.PASS, "Mengisi Password");
		}
		
		@When("^Privilege")
		public void privilege() {
			user.dropdwonPrivilege(configProperties.getPrivilege());
			extentTest.log(LogStatus.PASS, "Privilege");
		}
		
		@Then("^Menambahkan data")
		public void Menambahkan_data() {
			user.clickBtnSave();
			extentTest.log(LogStatus.PASS, "Menambahkan data");
		}
		
		//============================ Master Kota Activity ==========================
		@When("^Menampilkan data kota")
		public void Menampilkan_data_kota() {
			kota.clickGotoKota();
			extentTest.log(LogStatus.PASS, "Menampilkan data kota");
		}
		
		@When("^Menampilkan form data kota")
		public void Menampilkan_form_data_kota() {
			kota.clickBtnAddKota();
			extentTest.log(LogStatus.PASS, "Menampilkan form data kota");
		}
		
		@When("^Mengisi nama kota")
		public void Mengisi_nama_kota() {
			kota.inputKota(configProperties.getKota2());
			extentTest.log(LogStatus.PASS, "Mengisi nama kota");
		}
		
		@Then("^Menambahkan data kota")
		public void Menambahkan_data_kota() {
			kota.clickSaveKota();
			extentTest.log(LogStatus.PASS, "Menambahkan data");
		}
		
		//============================ Master area activity ==========================
		@When("^Menampilkan data area")
		public void Menampilkan_data_area() {
			area.clickArea();
			extentTest.log(LogStatus.PASS, "Menampilkan data area");
		}
		
		@When("^Menampilkan form data area")
		public void Menampilkan_form_data_area() {
			area.clickBtnAdd();
			extentTest.log(LogStatus.PASS, "Menampilkan form data area");
		}
		
		@When("^Mengisi nama area")
		public void Mengisi_nama_area() {
			area.inputArea(configProperties.getArea2());
			extentTest.log(LogStatus.PASS, "Mengisi nama area");
		}
		
		@Then("^Menambahkan data area")
		public void Menambahkan_data_area() {
			area.clickSave();
			extentTest.log(LogStatus.PASS, "Menambahkan data");
		}

	// ============================Report Activity=================================

	@When("^Menampilkan menu reporting")
	public void toReport() {
		reportPage.toReport();
		assertThat(reportPage.getTxtReport().toLowerCase(), containsString("report"));
		extentTest.log(LogStatus.PASS, "Menampilkan menu reporting");
	}

	@When("^Memilih dari drop down list")
	public void chooseLstItem() {
		reportPage.chooseKategori();
		;
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list");
	}

	@When("^Mengisi start date")
	public void fillSDate() {
		reportPage.chooseSDate(configProperties.getStartDate());
		extentTest.log(LogStatus.PASS, "Mengisi start date");
	}

	@When("^Mengisi end date")
	public void fillEDate() {
		reportPage.chooseEDate(configProperties.getEndDate());
		extentTest.log(LogStatus.PASS, "Mengisi end date");
	}

	@When("^Unduh laporan")
	public void downloadReport() {
		reportPage.downloadReport();
		extentTest.log(LogStatus.PASS, "Unduh laporan");
	}

	@Then("^Unduh template laporan")
	public void downloadReport2() {
		reportPage.downloadReport2();
		extentTest.log(LogStatus.PASS, "Unduh template laporan");

	}

	// ============================Worklist Activity=============================

	@When("^Menampilkan submenu")
	public void submenuWorklist() {
		reportPage.logout();
		login.inputUsername(configProperties.getSurveyor());
		login.inputPassword(configProperties.getPassword());
		login.clickButtonLogin();
		worklistPage.toWorklist();
		extentTest.log(LogStatus.PASS, "Menampilkan submenu");
	}

	@When("^Menampilkan Data Merchant yang belum divisit")
	public void subMenuNewData() {
		worklistPage.toNewData();
		extentTest.log(LogStatus.PASS, "Menampilkan Data Merchant yang belum divisit");
	}

	@When("^Memilih drop down list worklist")
	public void newDataDropDown() {
		worklistPage.chooseArea();
		extentTest.log(LogStatus.PASS, "Memilih drop down list worklist");
	}

	@When("^Menampilkan filter data")
	public void flterNewData() {
		worklistPage.clickFilter();
		extentTest.log(LogStatus.PASS, "Menampilkan filter data");
	}

	@When("^Mencari data newdata")
	public void findData() {
		worklistPage.searchItem("sate");
		extentTest.log(LogStatus.PASS, "Mencari data newdata");
	}

	@When("^Menampilkan form visit merchant")
	public void visitMerchant() {
		worklistPage.toVisitItem();
		extentTest.log(LogStatus.PASS, "Menampilkan form visit merchant");
	}

	@When("^Menampilkan form update data")
	public void updateData() {
		visitPage.editData();
		extentTest.log(LogStatus.PASS, "Menampilkan form update data");
	}

	@When("^Menyimpan perubahan data")
	public void saveUpdate() {
		assertThat(visitPage.successEdit().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS, "Menyimpan perubahan data");
	}

	@When("^Menampilkan form add data bank")
	public void addTID() {
		visitPage.addNewTID();
		extentTest.log(LogStatus.PASS, "Menyimpan perubahan data bank");
	}

	@When("^Memilih dari drop down list bank")
	public void chooseBank() {
		visitPage.chooseBank();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list bank");
	}

	@When("^Mengisi MID")
	public void fillMID() {
		visitPage.fillMID("MK2221I");
		extentTest.log(LogStatus.PASS, "Mengisi MID");
	}

	@When("^Mengisi TID")
	public void fillTID() {
		visitPage.fillTID("CD5231X");
		extentTest.log(LogStatus.PASS, "Mengisi TID");
	}

	@When("^Memilih dari drop down list acceptance")
	public void chooseAccept() {
		visitPage.confirmJCB();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list acceptance");
	}

	@When("^Upload foto")
	public void uploadValid() {
		visitPage.chooseFile("C:\\Users\\Lenovo\\Downloads\\Background JC.jpg");
		extentTest.log(LogStatus.PASS, "Upload foto");
	}

	@When("^Menyimpan data")
	public void submitForm() throws Throwable {
		visitPage.submitJCB();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menyimpan data");
		extentTest.log(LogStatus.FAIL, "Menyimpan data" + extentTest.addScreenCapture(screenShotPath));
	}

	@When("^Tidak menyimpan data")
	public void cancelForm() {
		visitPage.cancelJCB();
		extentTest.log(LogStatus.PASS, "Tidak menyimpan data");
	}

	@When("^Memilih dari drop down list JCB Sticker")
	public void chooseJCBSticker() {
		visitPage.chooseColSticker();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Sticker");
	}

	@When("^Memilih dari drop down list JCB Logo")
	public void chooseJCBLogo() {
		visitPage.chooseColStand();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Logo");
	}

	@When("^Memilih dari drop down list JCB Opn/Cls")
	public void chooseJCBOpnCls() {
		visitPage.chooseColOpenCls();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Opn/Cls");
	}

	@When("^Memilih dari drop down list JCB Name Card")
	public void chooseJCBNmCrd() {
		visitPage.chooseColCard();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list JCB Name Card");
	}

	@When("^Memilih dari drop down list Amex Sticker")
	public void chooseAmexSticker() {
		visitPage.chooseASticker();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Amex Sticker");
	}

	@When("^Memilih dari drop down list Amex Logo")
	public void chooseAmexLogo() {
		visitPage.choooseALogo();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Amex Logo");
	}

	@When("^Memilih dari drop down list Amex Opn/Cls")
	public void chooseAmexOpnCls() {
		visitPage.chooseAOpCls();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Amex Opn/Cls");
	}

	@When("^Cek Checkbox Bill Holder")
	public void cekBillHolder() {
		visitPage.checkItems1();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Bill Holder");
	}

	@When("^Cek Checkbox Sticker Sheet")
	public void cekStckSht() {
		visitPage.checkItems2();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Sticker Sheet");
	}

	@When("^Cek Checkbox Pen")
	public void cekPen() {
		visitPage.checkItems3();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Pen");
	}

	@When("^Cek Checkbox Reserved Sign")
	public void cekSign() {
		visitPage.checkItems4();
		extentTest.log(LogStatus.PASS, "Cek Checkbox Reserved Sign");
	}

	@When("^Simpan Data")
	public void submitVisited() throws Throwable {
		visitPage.submitVisited();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menyimpan visited data");
		extentTest.log(LogStatus.FAIL, "Simpan Data" + extentTest.addScreenCapture(screenShotPath));
	}

	@When("^Menampilkan form visit merchant other conditions")
	public void otherConditions() {
		worklistPage.toWorklist();
		worklistPage.toNewData();
		worklistPage.toOtherCondition();
		assertThat(otherPage.getPageHeader().toLowerCase(), containsString("visit merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan form visit merchant other conditions");

	}

	@When("^Menampilkan data merchant menu other conditions")
	public void conditionsMenu() {
		assertThat(otherPage.getPanelTitle1().toLowerCase(), containsString("data merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan data merchant menu other conditions");

	}

	@When("^Menampilkan form visit status")
	public void formVisitStatus() {
		assertThat(otherPage.getPanelTitle2().toLowerCase(), containsString("visit status"));
		extentTest.log(LogStatus.PASS, "Menampilkan form visit status");

	}

	@When("^Memilih dari drop down list Jika pilih Others akan muncul kolom tambahan")
	public void chooseStatus() {
		otherPage.chooseOptions("Test");
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list Jika pilih Others akan muncul kolom tambahan");

	}

	@When("^Konfirmasi data other conditions")
	public void confimConditions() {
		otherPage.confirm();
		assertThat(worklistPage.getAlertSuccess().getText().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS, "Konfirmasi data other conditions");

	}

	@Then("^Mengganti halaman aktif Worklist")
	public void pageWorklist() {
		worklistPage.toNextPrev();
		extentTest.log(LogStatus.PASS, "Mengganti halaman aktif Worklist");

	}

	@When("^Menampilkan form input new merchant")
	public void toAddNewMerchant() {
		worklistPage.toWorklist();
		worklistPage.toAddNewData();
		assertThat(addPage.getPanelTitle().getText().toLowerCase(), containsString("input new merchant"));
		extentTest.log(LogStatus.PASS, "Menampilkan form input new merchant");

	}

	@When("^Memilih dari drop down list kota new merchant")
	public void chooseNewCity() {
		addPage.chooseCity();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list kota new merchant");

	}

	@When("^Memilih dari drop down list area new merchant")
	public void chooseNewArea() {
		addPage.chooseArea();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list area new merchant");

	}

	@When("^Memilih dari drop down list batch new merchant")
	public void chooseNewBatch() {
		addPage.chooseBatch();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list batch new merchant");

	}

	@When("^Mengisi Name Merchant")
	public void fillNewName() {
		addPage.fillName("Test Merchant");
		extentTest.log(LogStatus.PASS, "Mengisi Name Merchant");

	}

	@When("^Mengisi Address")
	public void fillNewAddress() {
		addPage.fillAddress("Test Address");
		extentTest.log(LogStatus.PASS, "Mengisi Address");

	}

	@When("^Mengisi Address By Floor")
	public void fillFloorLoc() {
		addPage.fillAddrFloor("1");
		extentTest.log(LogStatus.PASS, "Mengisi Address By Floor");

	}

	@When("^Mengisi category")
	public void fillCategory() {
		addPage.fillCategory("FnB");
		extentTest.log(LogStatus.PASS, "Mengisi category");

	}

	@When("^Mengisi PIC")
	public void fillPIC() {
		addPage.fillPIC("User");
		extentTest.log(LogStatus.PASS, "Mengisi PIC");

	}

	@When("^Mengisi No Telp PIC")
	public void fillPhoneNum() {
		addPage.fillPhone("8888888888");
		extentTest.log(LogStatus.PASS, "Mengisi No Telp PIC");

	}

	@When("^Memilih dari drop down list PIC Position dan pilih Others akan muncul kolom tambahan")
	public void chooseOtherPosition() {
		addPage.choosePosition("Test other position");
		extentTest.log(LogStatus.PASS,
				"Memilih dari drop down list PIC Position dan pilih Others akan muncul kolom tambahan");

	}

	@When("^Memilih dari drop down list Merchant Acceptance dan pilih Others akan muncul kolom tambahan")
	public void chooseOtherAcceptance() {
		addPage.chooseAcceptCard("Other Test Accp");
		extentTest.log(LogStatus.PASS,
				"Memilih dari drop down list Merchant Acceptance dan pilih Others akan muncul kolom tambahan");

	}

	@When("^Memilih dari drop down list Bussiness issue dan pilih Others akan muncul kolom tambahan")
	public void chooseOtherIssue() {
		addPage.chooseIssue("New Issue");
		extentTest.log(LogStatus.PASS,
				"Memilih dari drop down list Bussiness issue dan pilih Others akan muncul kolom tambahan");

	}

	@When("^Simpan New Merchant data")
	public void saveNewMerchant() {
		addPage.submitForm();
		assertThat(visitPage.getSuccessCreateMsg().getText().toLowerCase(), containsString("success"));
		extentTest.log(LogStatus.PASS, "Simpan New Merchant data");

	}

	@Then("^tidak Simpan New Merchant data")
	public void cancelCreateMerchant() {
		worklistPage.toWorklist();
		worklistPage.toAddNewData();
		addPage.fillPhone("0988778899");
		addPage.cancelForm();
		extentTest.log(LogStatus.PASS, "tidak Simpan New Merchant data");

	}

	// ============================Completed Activity============================

	@When("^Menampilkan menu completed")
	public void toCompleted() {
		completedPage.toCompleted();
		assertThat(completedPage.getTxtDataCompleted(), containsString("completed"));
		extentTest.log(LogStatus.PASS, "Menampilkan menu completed");
	}

	@When("^Memilih dari drop down list complete")
	public void chooseItems() {
		completedPage.chooseArea();
		extentTest.log(LogStatus.PASS, "Memilih dari drop down list complete");
	}

	@When("^Menampilkan hasil filter")
	public void filterData() throws Throwable {
		completedPage.testFilter();
		String screenShotPath = GetScreenShot.capture(driver, "Gagal menampilkan hasil filter");
		extentTest.log(LogStatus.FAIL, "Menampilkan hasil filter" + extentTest.addScreenCapture(screenShotPath));
	}

	@When("^Mencari data")
	public void search() {
		completedPage.searchData(configProperties.getSearchKeyCompleted());
		assertThat(completedPage.getTxtCheck(), containsString("chigo"));
		extentTest.log(LogStatus.PASS, "Mencari data");
	}

	@When("^Menampilkan foto laporan")
	public void viewPhoto() {
		completedPage.viewPhoto();
		assertThat(completedPage.getMyModalLabel(), containsString("view"));
		completedPage.close();
		extentTest.log(LogStatus.PASS, "Menampilkan foto laporan");
	}

	@When("^Menampilkan Info EDC")
	public void viewEDC() {
		completedPage.viewEDC();
		assertThat(completedPage.getMyModalLabel(), containsString("view"));
		completedPage.close();
		extentTest.log(LogStatus.PASS, "Menampilkan Info EDC");
	}

	@Then("^Mengganti halaman aktif")
	public void changePage() {
		completedPage.clearSearch();
		completedPage.changePage();
		extentTest.log(LogStatus.PASS, "Mengganti halaman aktif");
		completedPage.logout();
	}

	@After
	public void closeObjects() {
		report.endTest(this.extentTest);
		report.flush();

	}

}

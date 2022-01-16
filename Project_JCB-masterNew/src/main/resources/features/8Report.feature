Feature: Report
	Scenario: Modul Report
		When Menampilkan menu reporting
		And Memilih dari drop down list
		And Mengisi start date
		And Mengisi end date
		And Unduh laporan
		Then Unduh template laporan
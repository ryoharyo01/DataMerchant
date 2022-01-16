Feature: Worklist
	Scenario: Modul Worklist
		When Menampilkan form input new merchant
		And Memilih dari drop down list kota new merchant
		And Memilih dari drop down list area new merchant
		And Memilih dari drop down list batch new merchant
		And Mengisi Name Merchant
		And Mengisi Address
		And Mengisi Address By Floor
		And Mengisi category
		And Mengisi PIC
		And Mengisi No Telp PIC
		And Memilih dari drop down list PIC Position dan pilih Others akan muncul kolom tambahan
		And Memilih dari drop down list Merchant Acceptance dan pilih Others akan muncul kolom tambahan
		And Memilih dari drop down list Bussiness issue dan pilih Others akan muncul kolom tambahan
		And Simpan New Merchant data
		Then tidak Simpan New Merchant data
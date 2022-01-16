Feature: Login activity
	Scenario: input username and password
		Given Menampilkan form login
		When Mengisi username
		And Mengisi Password
		And Login ke sistem JCB
		Then Muncul pesan selamat datang superadmin2
Feature: Dashboard activity
	Scenario: Menampilkan halaman dashboard
	When Menuju halaman dashboard
	And Menampilkan jumlah monthly visit
	And Menampilkan jumlah unvisit
	And Menampilkan jumlah monthly price
	And Menampilkan jumlah total price
	Then Menampilkan data table summary by area
	
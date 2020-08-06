$(document).ready(
  function() {
    var table = $('#example').DataTable({
      buttons : [ 'copy', 'excel', 'pdf', 'print', 'colvis' ]
    });
    table.buttons().container().appendTo(
        '#example_wrapper .col-sm-6:eq(0)');
  });

  var request = new XMLHttpRequest();
	$(document).ready(function() {
		$('#ab').DataTable();
	});

package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Chart {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Chart
	public static Var monthlyUserChart() throws Exception {
		return new Callable<Var>() {

			private Var months = Var.VAR_NULL;
			private Var monthName = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;

			public Var call() throws Exception {
				months = cronapi.database.Operations.query(Var.valueOf("app.entity.User"), Var.valueOf(
						"select case when extract(month u.addedDate) = 1 then \"Janeiro\" when extract(month u.addedDate) = 2 then \"Fevereiro\" when extract(month u.addedDate) = 3 then \"Março\" when extract(month u.addedDate) = 4 then \"Abril\" when extract(month u.addedDate) = 5 then \"Maio\" when extract(month u.addedDate) = 6 then \"Junho\" when extract(month u.addedDate) = 7 then \"Julho\" when extract(month u.addedDate) = 8 then \"Agosto\" when extract(month u.addedDate) = 9 then \"Setembro\" when extract(month u.addedDate) = 10 then \"Outubro\" when extract(month u.addedDate) = 11 then \"Novembro\" else \"Dezembro\" end as monthName, extract(month u.addedDate) as monthNumber from User u group by monthName , monthNumber order by monthNumber asc"));
				monthName = cronapi.list.Operations.newList();
				System.out.println(months.getObjectAsString());
				for (Iterator it_i = months.iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					cronapi.list.Operations.addFirst(monthName,
							cronapi.map.Operations.getMapField(i, Var.valueOf("monthName")));
					System.out.println(i.getObjectAsString());
					System.out.println(monthName.getObjectAsString());
				} // end for
				cronapi.chart.Operations.createChart(Var.valueOf("chart5115"), Var.valueOf("bar"), monthName,
						Var.VAR_NULL,
						cronapi.chart.Operations.createChartSerie(Var.valueOf("Users"),
								cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
										Var.valueOf(
												"select COUNT(u.id) from User u  group by extract(month u.addedDate) order by extract(month u.addedDate) desc")),
								Var.VAR_NULL));
				return Var.VAR_NULL;
			}
		}.call();
	}

}

dataSource {
	pooled = true
	driverClassName = "org.postgresql.Driver"
	username = "postgres"
	password = "root"
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:postgresql://localhost:5432/MidiaPt"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:postgresql://localhost:5432/MidiaPt"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:postgresql://localhost:5432/MidiaPt"
		}
	}
}
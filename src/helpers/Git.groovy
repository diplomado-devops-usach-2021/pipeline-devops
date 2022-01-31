package helpers

def merge(String ramaOrigen, String ramaDestino){
	println "Este método realiza un merge ${ramaOrigen} y ${ramaDestino}"

	checkout(ramaOrigen)
	checkout(ramaDestino)

	sh """
		git merge ${ramaOrigen}
		git commit -m "Merge de ${ramaOrigen}"
		git push origin ${ramaDestino}
	"""
}

def tag(String ramaOrigen){
	println "Este método realiza un tag en master de ${ramaOrigen}"

	/*
		- validar que la rama release cumpla con una nomenclatura definida: release-v(major)-(minor)-(patch)
		- obtener el valor desde la "v" en adelante, ejemplo: release-v1-0-0 ... obtener sólo 1-0-0
	*/
}

def checkout(String rama){
	sh "git reset --hard HEAD; git checkout origin/${rama}; git pull origin/${rama}"
}

return this;
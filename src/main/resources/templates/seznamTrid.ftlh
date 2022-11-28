[#ftl]

    <div>
        [#list seznam as trida]
            <a href="/detail/${trida.id}">
                    <div>${trida.nazev}</div>
            </a>
        [/#list]
    </div>

export default function AddCarPage()
{
    function submitt(event)
    {
        event.preventDefault();
        const fd = new FormData(event.target);
        const vid = fd.get("vid");
        const marka = fd.get("marka");
        const model = fd.get("model");
        const godina = fd.get("godina");
        const cvqt = fd.get("cvqt");
        const kilometri = fd.get("kilometri");
        const cena = fd.get("cena");
        console.log({vid, marka, model, godina, cvqt, kilometri, cena });
    }

    return <div>
        <form onSubmit={submitt}>
            <div>
                <label>Vid</label>
                <input type="text" name="vid"/>
            </div>
            <div>
                <label>Marka</label>
                <input type="text" name="marka"/>
            </div>
            <div>
                <label>Model</label>
                <input type="text" name="model"/>
            </div>
            <div>
                <label>Godina</label>
                <input type="number" name="godina"/>
            </div>
            <div>
                <label>Cvqt</label>
                <input type="text" name="cvqt"/>
            </div>
            <div>
                <label>Izminati kilometri</label>
                <input type="text" name="kilometri"/>
            </div>
            <div>
                <label>Cena za den</label>
                <input type="text" name="cena"/>
            </div>
            <div>
                <input type="submit"/>
            </div>
        </form>
    </div>
}